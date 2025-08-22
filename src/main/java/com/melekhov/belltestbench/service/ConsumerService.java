package com.melekhov.belltestbench.service;

import com.melekhov.belltestbench.dto.KafkaMessageDto;

public interface ConsumerService {
    void save(KafkaMessageDto kafkaMessage);
}
