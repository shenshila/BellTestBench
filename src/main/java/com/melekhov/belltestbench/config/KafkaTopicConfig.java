package com.melekhov.belltestbench.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaTopicConfig {

    public static final String POSTED_MESSAGE_TOPIC = "posted-messages";

    @Bean
    public NewTopic postedMessages() {
        return new NewTopic(POSTED_MESSAGE_TOPIC, 1, (short) 1);
    }

}
