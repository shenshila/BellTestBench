package com.melekhov.belltestbench.service.impl;

import com.melekhov.belltestbench.kafka.KafkaTopicConfig;
import com.melekhov.belltestbench.dto.KafkaMessageDto;
import com.melekhov.belltestbench.service.ProducerService;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProducerServiceImpl implements ProducerService {
    private final KafkaTemplate<String, Object> kafkaTemplate;

    @Override
    public void sendMessage(String msgId, String method, String uri) {
        KafkaMessageDto kafkaMessageDto = new KafkaMessageDto(
                msgId,
                System.currentTimeMillis(),
                method,
                uri
        );

        kafkaTemplate.send(KafkaTopicConfig.POSTED_MESSAGE_TOPIC, kafkaMessageDto);
    }

    @Override
    public void deleteOrderById(Long orderId) {
        kafkaTemplate.send(KafkaTopicConfig.DELETED_ORDER_TOPIC, orderId);
    }


}
