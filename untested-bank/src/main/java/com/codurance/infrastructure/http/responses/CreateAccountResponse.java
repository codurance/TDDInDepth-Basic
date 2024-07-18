package com.codurance.infrastructure.http.responses;

import java.util.UUID;

public class CreateAccountResponse {
    public UUID id;

    public CreateAccountResponse(UUID id) {
        this.id = id;
    }
}
