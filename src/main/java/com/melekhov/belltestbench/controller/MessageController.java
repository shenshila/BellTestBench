package com.melekhov.belltestbench.controller;

import com.melekhov.belltestbench.dto.MessageRequestDto;
import com.melekhov.belltestbench.service.KafkaMessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api")
@RequiredArgsConstructor
public class MessageController {
    private final KafkaMessageService producer;

    @PostMapping("/post-message")
    public ResponseEntity<String> postMessage(@RequestBody MessageRequestDto requestMessage) {
        try {
            producer.sendMessage(requestMessage.getMsgId(), "POST", "/post-message");
            return ResponseEntity.ok("Message posted successfully");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Failed to send message: " + e.getMessage());
        }
    }

}
