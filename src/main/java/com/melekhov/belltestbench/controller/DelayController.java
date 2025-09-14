package com.melekhov.belltestbench.controller;

import com.melekhov.belltestbench.util.DelayManager;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequestMapping("/delay")
@RequiredArgsConstructor
public class DelayController {
    private final DelayManager delayManager;

    @GetMapping()
    public ResponseEntity<Map<String, Integer>> getDelays() {
        return ResponseEntity.ok(delayManager.getAllDelays());
    }

    @PostMapping("update/{key}/{value}")
    public ResponseEntity<String> updateDelay(
            @PathVariable String key,
            @PathVariable Integer value
    ) {
        if (!delayManager.getAllDelays().containsKey(key)) {
            return ResponseEntity.status(404).body("Key not found");
        }

        try {
            delayManager.updateDelay(key, value);
            return ResponseEntity.ok("Updated delay for " + key + " = " + value + "ms");
        } catch (Exception ex) {
            return ResponseEntity.badRequest().build();
        }

    }
}
