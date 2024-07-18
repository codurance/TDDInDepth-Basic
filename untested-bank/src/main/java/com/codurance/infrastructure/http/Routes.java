package com.codurance.infrastructure.http;

import com.codurance.application.AccountService;
import com.codurance.infrastructure.http.api.BankStatementApi;
import com.codurance.infrastructure.http.api.CreateAccountApi;
import com.codurance.infrastructure.http.api.DepositApi;

import static spark.Spark.get;
import static spark.Spark.post;

public class Routes {

    private final AccountService accountService;
    private BankStatementApi bankStatementApi;
    private DepositApi depositApi;
    private CreateAccountApi createAccountApi;

    public Routes(AccountService accountService) {

        this.accountService = accountService;
    }

    public void create() {
        createAccountApi = new CreateAccountApi(accountService);
        depositApi = new DepositApi(accountService);
        bankStatementApi = new BankStatementApi(accountService);
        bankRoutes();
    }

    public void bankRoutes() {
        post("accounts", (req, res) -> createAccountApi.execute(req, res));
        post("accounts/:id/deposit", (req, res) -> depositApi.execute(req, res));
        get("accounts/:id/statement", (req, res) -> bankStatementApi.execute(req, res));
    }
}

