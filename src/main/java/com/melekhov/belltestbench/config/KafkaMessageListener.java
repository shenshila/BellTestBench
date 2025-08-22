package com.melekhov.belltestbench.config;

import com.melekhov.belltestbench.dto.KafkaMessageDto;
import com.melekhov.belltestbench.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class KafkaMessageListener {

    private final MessageService messageService;

    @KafkaListener(
            topics = "posted-messages",
            groupId = "${spring.kafka.consumer.group-id}")
    public void listenMessage(KafkaMessageDto message){
        System.out.println(message);
        messageService.save(message);
    }

}
