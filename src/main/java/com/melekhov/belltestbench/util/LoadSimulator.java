package com.melekhov.belltestbench.util;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Component
public class LoadSimulator implements CommandLineRunner {
    private final RestTemplate restTemplate = new RestTemplate();

    @Override
    public void run(String... args) throws Exception {
        for (int i = 0; i < 200; i++) {
            Map<String, String> body = Map.of("msg_id", "test-" + i);
            restTemplate.postForObject("http://localhost:8081/api/post-message", body, String.class);
        }
    }
}
