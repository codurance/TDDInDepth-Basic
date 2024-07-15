package com.codurance.module1.TestDoublesMockito.Mock;

import com.codurance.module1.TestDoubles.Mock.AccountService;
import com.codurance.module1.TestDoubles.Mock.Logger;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class AccountServiceShould {
    /**
     * We want to test the AccountService class to ensure that it logs a message when a deposit is added.
     */
    @Test
    public void log_a_message_each_time_a_deposit_is_added() {
        Logger logger = mock(Logger.class);

        AccountService accountService = new AccountService(logger);

        accountService.addDeposit(100.0);
        accountService.addDeposit(50.0);

        verify(logger).log("Deposit added: 100.0");
        verify(logger).log("Deposit added: 50.0");    }
}
