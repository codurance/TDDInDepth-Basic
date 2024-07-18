package com.codurance.infrastructure.http.api;

import com.codurance.application.AccountService;
import com.codurance.application.DepositRequest;
import com.codurance.application.NoAccountFoundException;
import com.google.gson.Gson;
import spark.Request;
import spark.Response;

public class DepositApi {
    private final AccountService accountService;

    public DepositApi(AccountService accountService) {

        this.accountService = accountService;
    }

    public String execute(Request req, Response res) {
        String id = req.params("id");
        DepositRequest depositRequest = new Gson().fromJson(req.body(), DepositRequest.class);
        depositRequest.id = id;

        try {
            accountService.deposit(depositRequest);
        } catch (NoAccountFoundException e) {
            res.status(404);
            res.type("application/json");
            res.body(new Gson().toJson(e));
        }

        res.status(201);
        return "";
    }
}
