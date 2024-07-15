package com.codurance.module1.TestDoublesMockito.Mock;

import com.codurance.module1.TestDoubles.Mock.AccountService;
import org.junit.jupiter.api.Test;

public class AccountServiceShould {
    /**
     * We want to test the AccountService class to ensure that it logs a message when a deposit is added.
     */
    @Test
    public void log_a_message_each_time_a_deposit_is_added() {
        MockLogger mockLogger = new MockLogger();

        mockLogger.expect("Deposit added: 100.0");
        mockLogger.expect("Deposit added: 50.0");

        AccountService accountService = new AccountService(mockLogger);

        accountService.addDeposit(100.0);
        accountService.addDeposit(50.0);

        mockLogger.verify();
    }
}
