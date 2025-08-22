package com.melekhov.belltestbench.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class MessageRequestDto {
    @JsonProperty("msg_id")
    private String msgId;
}
