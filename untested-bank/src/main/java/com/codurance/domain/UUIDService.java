package com.codurance.domain;

import java.util.UUID;

public interface UUIDService {
    UUID randomUUID();

    UUID convertToUUID(String id);
}
