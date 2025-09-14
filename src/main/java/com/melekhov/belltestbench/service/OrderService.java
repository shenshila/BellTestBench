package com.melekhov.belltestbench.service;

import com.melekhov.belltestbench.dto.OrderRequestDto;
import com.melekhov.belltestbench.dto.OrderResponseDto;
import com.melekhov.belltestbench.model.Order;

public interface OrderService {
    public OrderResponseDto createOrder(OrderRequestDto orderRequestDto);
}
