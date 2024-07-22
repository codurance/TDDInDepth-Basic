package com.codurance.application;

import com.codurance.domain.Account;
import com.codurance.domain.Calendar;
import com.codurance.domain.Statement;
import com.codurance.domain.StatementLine;
import com.codurance.infrastructure.persistence.MongoAccountRepository;
import com.codurance.infrastructure.persistence.MongoDatabaseManager;
import com.mongodb.client.MongoClient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@Testcontainers
class AccountServiceIntegrationTest {
    @Container
    final MongoDBContainer mongoDBContainer = new MongoDBContainer("mongo:4.0.10");

    private MongoAccountRepository mongoAccountRepository;

    @BeforeEach
    void setUp() {
        mongoDBContainer.start();
        String connectionString = mongoDBContainer.getConnectionString();
        MongoClient mongoClient = MongoDatabaseManager.getMongoClient(connectionString);
        mongoAccountRepository = new MongoAccountRepository(mongoClient);
    }

    @Test
    public void createAccountDepositAndSeeDepositInStatement() throws NoAccountFoundException {
        JavaUUIDService uuidService = new JavaUUIDService();
        Calendar calendar = mock(Calendar.class);
        AccountService accountService = new AccountService(mongoAccountRepository, uuidService, calendar);
        int amount = 100;
        int balance = 100;
        Date transactionDate = new Date(2021, 2, 23);
        when(calendar.today()).thenReturn(transactionDate);
        StatementLine expectedStatementLine = new StatementLine(amount, transactionDate, balance);

        Account account = accountService.createAccount();
        accountService.deposit(new DepositRequest(account.id.toString(), amount));
        Statement statement = accountService.createStatementForAccountWith(account.id.toString());

        assertIterableEquals(List.of(expectedStatementLine), statement.statementLines);
    }
}