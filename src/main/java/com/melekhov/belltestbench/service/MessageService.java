package com.melekhov.belltestbench.service;

import com.melekhov.belltestbench.dto.KafkaMessageDto;
import com.melekhov.belltestbench.model.KafkaMessage;

public interface MessageService {
    void save(KafkaMessageDto kafkaMessage);
}
