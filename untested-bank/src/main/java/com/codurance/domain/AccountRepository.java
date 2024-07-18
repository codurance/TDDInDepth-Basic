package com.codurance.domain;

import java.util.Optional;
import java.util.UUID;

public interface AccountRepository {
    Optional<Account> findAccountBy(UUID id);

    void saveAccount(Account account);
}
