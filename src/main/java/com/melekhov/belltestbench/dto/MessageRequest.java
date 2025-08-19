package com.melekhov.belltestbench.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class MessageRequest {
    @JsonProperty("msg_id")
    private String msgId;
}
