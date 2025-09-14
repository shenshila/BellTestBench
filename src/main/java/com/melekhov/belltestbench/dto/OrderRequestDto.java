package com.melekhov.belltestbench.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequestDto {
    private UUID sessionId;
    private String productName;
    private int quantity;
}
