package com.codurance.infrastructure.persistence;

import com.codurance.domain.Account;
import com.codurance.domain.AccountRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

public class InMemoryAccountRepository implements AccountRepository {
    Map<UUID, Account> accounts = new HashMap<>();

    @Override
    public Optional<Account> findAccountBy(UUID id) {
        return Optional.of(accounts.get(id));
    }

    @Override
    public void saveAccount(Account account) {
        accounts.put(account.id, account);
    }
}
