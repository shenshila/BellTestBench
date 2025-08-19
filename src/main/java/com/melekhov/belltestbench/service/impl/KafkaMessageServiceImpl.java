package com.melekhov.belltestbench.service.impl;

import com.melekhov.belltestbench.config.KafkaTopicConfig;
import com.melekhov.belltestbench.model.KafkaMessage;
import com.melekhov.belltestbench.service.KafkaMessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class KafkaMessageServiceImpl implements KafkaMessageService {
    private final KafkaTemplate<String, Object> kafkaTemplate;

    @Override
    public void sendMessage(String msgId, String method, String uri) {
//        Map<String, Object> message = new HashMap<>();
//
//        message.put("msgId", msgId);
//        message.put("timestamp", System.currentTimeMillis());
//        message.put("method", method);
//        message.put("uri", uri);

        KafkaMessage kafkaMessage = new KafkaMessage(
                msgId,
                System.currentTimeMillis(),
                method,
                uri
        );

        kafkaTemplate.send(KafkaTopicConfig.POSTED_MESSAGE_TOPIC, kafkaMessage);

//        kafkaTemplate.send(KafkaTopicConfig.POSTED_MESSAGE_TOPIC, message.toString());
    }
}
