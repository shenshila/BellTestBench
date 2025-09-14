package com.melekhov.belltestbench.kafka;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaTopicConfig {

    public static final String POSTED_MESSAGE_TOPIC = "posted-messages";
    public static final String DELETED_ORDER_TOPIC = "deleted-orders";

    @Bean
    public NewTopic postedMessages() {
        return new NewTopic(POSTED_MESSAGE_TOPIC, 1, (short) 1);
    }

    @Bean NewTopic deleteOrder() {
        return new NewTopic(DELETED_ORDER_TOPIC, 1, (short) 1);
    }

}
