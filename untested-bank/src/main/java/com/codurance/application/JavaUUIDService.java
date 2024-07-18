package com.codurance.application;

import com.codurance.domain.UUIDService;

import java.util.UUID;

public class JavaUUIDService implements UUIDService {
    @Override
    public UUID randomUUID() {
        return UUID.randomUUID();
    }

    @Override
    public UUID convertToUUID(String id) {
        return UUID.fromString(id);
    }
}
