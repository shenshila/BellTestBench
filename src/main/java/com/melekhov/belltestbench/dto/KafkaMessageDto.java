package com.melekhov.belltestbench.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class KafkaMessageDto {
    private String msg_id;
    private long timestamp;
    private String method;
    private String uri;
}
