package com.melekhov.belltestbench.controller;

import com.melekhov.belltestbench.service.SessionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/session")
@RequiredArgsConstructor
public class SessionController {
    private final SessionService sessionService;

    @PostMapping("/create")
    public ResponseEntity<UUID> createSession(){
        try {
            UUID sessionId = sessionService.createSession();
            return ResponseEntity.ok(sessionId);
        } catch (Exception e) {
            return ResponseEntity.status(401).build();
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteSession(@RequestHeader("X-Session-Id") String sessionId){
        try {
            UUID id  = UUID.fromString(sessionId);
            sessionService.deleteSession(id);
            return ResponseEntity.ok("Session deleted: " + id);
        } catch (Exception e) {
            return ResponseEntity.status(401).build();
        }
    }

}
