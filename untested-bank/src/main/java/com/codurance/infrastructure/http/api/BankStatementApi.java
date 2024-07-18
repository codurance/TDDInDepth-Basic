package com.codurance.infrastructure.http.api;

import com.codurance.application.AccountService;
import com.codurance.application.NoAccountFoundException;
import com.codurance.domain.Statement;
import com.google.gson.Gson;
import spark.Request;
import spark.Response;

public class BankStatementApi {
    private final AccountService accountService;

    public BankStatementApi(AccountService accountService) {
        this.accountService = accountService;
    }

    public String execute(Request req, Response res) {
        String id = req.params("id");

        Statement statement = null;
        try {
            statement = accountService.createStatementForAccountWith(id);
        } catch (NoAccountFoundException e) {
            res.status(404);
            res.type("application/json");
            res.body(new Gson().toJson(e));
        }

        res.status(200);
        res.type("application/json");

        return new Gson().toJson(statement);
    }
}
