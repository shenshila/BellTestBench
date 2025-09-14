package com.melekhov.belltestbench.service;

import org.springframework.http.ResponseEntity;

import java.util.UUID;

public interface SessionService {
    public UUID createSession();
    public void deleteSession(UUID sessionId);
    public boolean validateSession(UUID sessionId);
}
