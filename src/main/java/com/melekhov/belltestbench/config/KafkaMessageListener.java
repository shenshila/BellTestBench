package com.melekhov.belltestbench.config;

import com.melekhov.belltestbench.dto.KafkaMessageDto;
import com.melekhov.belltestbench.service.ConsumerService;
import com.melekhov.belltestbench.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class KafkaMessageListener {

    private final ConsumerService consumerService;
    private final OrderService orderService;

    @KafkaListener(
            topics = "posted-messages",
            groupId = "${spring.kafka.consumer.group-id}")
    public void listenMessage(KafkaMessageDto message){
        System.out.println(message);
        consumerService.save(message);
    }

    @KafkaListener(
            topics = "deleted-orders",
            groupId = "${spring.kafka.consumer.group-id}")
    public void deleteOrder(String id) {
        System.out.println("Delete Order Successfully");
        orderService.deleteOrderById(Long.parseLong(id));
    }

}
