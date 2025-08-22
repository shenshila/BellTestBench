package com.melekhov.belltestbench.mapper;

import com.melekhov.belltestbench.dto.KafkaMessageDto;
import com.melekhov.belltestbench.model.KafkaMessage;
import org.springframework.stereotype.Component;

@Component
public class KafkaMessageMapper {

    public KafkaMessage mapKafkaMessageDtoToKafkaMessage(KafkaMessageDto kafkaMessageDto) {
        return KafkaMessage.builder()
                .msgId(kafkaMessageDto.getMsg_id())
                .method(kafkaMessageDto.getMethod())
                .timestamp(kafkaMessageDto.getTimestamp())
                .uri(kafkaMessageDto.getUri())
                .build();
    }

}
