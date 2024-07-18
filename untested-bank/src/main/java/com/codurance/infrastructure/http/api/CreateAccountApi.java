package com.codurance.infrastructure.http.api;

import com.codurance.application.AccountService;
import com.codurance.domain.Account;
import com.codurance.infrastructure.http.responses.CreateAccountResponse;
import com.google.gson.Gson;
import spark.Request;
import spark.Response;

public class CreateAccountApi {
    private final AccountService accountService;

    public CreateAccountApi(AccountService accountService) {
        this.accountService = accountService;
    }

    public String execute(Request req, Response res) {
        Account account = accountService.createAccount();

        res.status(201);
        return new Gson().toJson(new CreateAccountResponse(account.id));
    }
}
