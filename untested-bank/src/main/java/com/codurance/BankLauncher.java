package com.codurance;

import com.codurance.application.AccountService;
import com.codurance.application.JavaCalendar;
import com.codurance.application.JavaUUIDService;
import com.codurance.domain.AccountRepository;
import com.codurance.domain.Calendar;
import com.codurance.domain.UUIDService;
import com.codurance.infrastructure.http.Routes;
import com.codurance.infrastructure.persistence.MongoAccountRepository;
import com.codurance.infrastructure.persistence.MongoDatabaseManager;

public class BankLauncher {
    public static void main(String[] args) {
        AccountRepository accountRepository = new MongoAccountRepository(MongoDatabaseManager.getMongoClient("mongodb://localhost:27017"));
        UUIDService uuidService = new JavaUUIDService();
        Calendar calendar = new JavaCalendar();
        AccountService accountService = new AccountService(accountRepository, uuidService, calendar);
        Routes routes = new Routes(accountService);
        new Bank(routes).start();
    }

}