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
    public ResponseEntity<Void> deleteSession(@RequestBody UUID uuid){
        try {
            sessionService.deleteSession(uuid);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(401).build();
        }
    }

}
