package com.codurance.application;

import com.codurance.domain.*;

import java.util.Optional;
import java.util.UUID;

public class AccountService {
    private final AccountRepository accountRepository;
    private final UUIDService uuidService;
    private final Calendar calendar;

    public AccountService(AccountRepository accountRepository, UUIDService uuidService, Calendar calendar) {
        this.accountRepository = accountRepository;
        this.uuidService = uuidService;
        this.calendar = calendar;
    }

    public void deposit(DepositRequest depositRequest) throws NoAccountFoundException {
        UUID uuid = uuidService.convertToUUID(depositRequest.id);
        Account account = getAccountBy(uuid);

        AccountTransaction transaction = createTransactionFor(depositRequest.amount);
        account.addTransaction(transaction);

        this.accountRepository.saveAccount(account);
    }

    public Statement createStatementForAccountWith(String id) throws NoAccountFoundException {
        UUID uuid = uuidService.convertToUUID(id);
        Account account = getAccountBy(uuid);

        return Statement.from(account.getTransactions());
    }

    public Account createAccount() {
        UUID uuid = uuidService.randomUUID();
        Account account = new Account(uuid);
        accountRepository.saveAccount(account);
        return account;
    }

    private Account getAccountBy(UUID uuid) throws NoAccountFoundException {
        Optional<Account> maybeAccount = this.accountRepository.findAccountBy(uuid);
        if (maybeAccount.isPresent()) {
            return maybeAccount.get();
        } else {
            throw new NoAccountFoundException();
        }
    }

    private AccountTransaction createTransactionFor(int amount) {
        return new AccountTransaction(uuidService.randomUUID(), calendar.today(), amount);
    }
}
