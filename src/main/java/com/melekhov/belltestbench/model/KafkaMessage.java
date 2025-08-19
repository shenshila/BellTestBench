package com.melekhov.belltestbench.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class KafkaMessage {
    private String msg_id;
    private long timestamp;
    private String method;
    private String uri;
}
