package com.melekhov.belltestbench.service.impl;

import com.melekhov.belltestbench.model.Session;
import com.melekhov.belltestbench.service.SessionService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Service
@RequiredArgsConstructor
public class SessionServiceImpl implements SessionService {
    private final ConcurrentHashMap<UUID, Session> sessions = new ConcurrentHashMap<>();

    @Override
    public UUID createSession() {
        UUID uuid = UUID.randomUUID();
        sessions.put(uuid, new Session(uuid, Instant.now()));
        return uuid;
    }

    @Override
    public void deleteSession(UUID sessionId) {
        sessions.remove(sessionId);
    }

    public boolean validateSession(UUID sessionId) {
        return sessions.containsKey(sessionId);
    }
}
