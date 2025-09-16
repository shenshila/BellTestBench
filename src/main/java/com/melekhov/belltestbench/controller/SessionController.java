package com.melekhov.belltestbench.controller;

import com.melekhov.belltestbench.service.SessionService;
import com.melekhov.belltestbench.util.DelayUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/session")
@RequiredArgsConstructor
@Log4j2
public class SessionController {
    private final SessionService sessionService;
    private final DelayUtil delayUtil;

    @PostMapping("/create")
    public ResponseEntity<UUID> createSession(){
        delayUtil.applyDelay("session.create");
        try {
            UUID sessionId = sessionService.createSession();
            log.info("AAAAAAAAAAAAAAASession created with id: {} has been created", sessionId);
            return ResponseEntity.ok(sessionId);
        } catch (Exception e) {
            return ResponseEntity.status(401).build();
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteSession(@RequestHeader("X-Session-Id") String sessionId){
        delayUtil.applyDelay("session.delete");
        try {
            UUID id  = UUID.fromString(sessionId);
            sessionService.deleteSession(id);
            log.info("AAAAAAAAAAAAAAASession DEELETED with id: {} has been deleted", id);
            return ResponseEntity.ok("Session deleted: " + id);
        } catch (Exception e) {
            return ResponseEntity.status(401).build();
        }
    }

}
