package com.melekhov.belltestbench.service.impl;

import com.melekhov.belltestbench.dto.KafkaMessageDto;
import com.melekhov.belltestbench.mapper.KafkaMessageMapper;
import com.melekhov.belltestbench.model.KafkaMessage;
import com.melekhov.belltestbench.repository.MessageRepository;
import com.melekhov.belltestbench.service.ConsumerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ConsumerServiceImpl implements ConsumerService {
    private final MessageRepository messageRepository;
    private final KafkaMessageMapper kafkaMessageMapper;

    @Override
    public void save(KafkaMessageDto kafkaMessageDto) {
        KafkaMessage kafkaMessage = kafkaMessageMapper.mapKafkaMessageDtoToKafkaMessage(kafkaMessageDto);

        messageRepository.save(kafkaMessage);
    }
}
