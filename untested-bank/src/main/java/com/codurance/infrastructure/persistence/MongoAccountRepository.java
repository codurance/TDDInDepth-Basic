package com.codurance.infrastructure.persistence;

import com.codurance.domain.Account;
import com.codurance.domain.AccountRepository;
import com.codurance.domain.AccountTransaction;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.ReplaceOptions;
import org.bson.Document;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class MongoAccountRepository implements AccountRepository {
    private final MongoCollection<Document> accountCollection;

    public MongoAccountRepository(MongoClient mongoClient) {
        this.accountCollection = mongoClient.getDatabase("bank").getCollection("accounts");
    }

    @Override
    public Optional<Account> findAccountBy(UUID id) {
        Document accountDocument = accountCollection.find(Filters.eq("id", id.toString())).first();

        if (accountDocument != null) {
            return Optional.of(convertDocumentToAccount(accountDocument));
        } else {
            return Optional.empty();
        }
    }

    @Override
    public void saveAccount(Account account) {
        Document accountDocument = convertAccountToDocument(account);

        accountCollection.replaceOne(
            Filters.eq("id", account.id.toString()),
            accountDocument,
            new ReplaceOptions().upsert(true));
    }

    private static Document convertAccountToDocument(Account account) {
        return new Document("id", account.id.toString())
            .append("transactions",
                convertTransactionsToDocuments(account.getTransactions()));
    }

    private static List<Document> convertTransactionsToDocuments(List<AccountTransaction> transactions) {
        return transactions.stream()
            .map(transaction -> new Document("id", transaction.id.toString())
                .append("date", transaction.date)
                .append("amount", transaction.amount))
            .toList();
    }

    private AccountTransaction convertDocumentToTransaction(Document document) {
        UUID id = UUID.fromString(document.getString("id"));
        Date date = document.getDate("date");
        int amount = document.getInteger("amount");

        return new AccountTransaction(id, date, amount);
    }

    private Account convertDocumentToAccount(Document accountDocument) {
        List<Document> transactionDocuments = (List<Document>) accountDocument.get("transactions");
        List<AccountTransaction> accountTransactions = transactionDocuments.stream()
            .map(this::convertDocumentToTransaction)
            .toList();

        return new Account(
            UUID.fromString(accountDocument.getString("id")),
            accountTransactions
        );
    }
}
