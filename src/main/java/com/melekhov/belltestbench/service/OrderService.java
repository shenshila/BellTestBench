package com.melekhov.belltestbench.service;

import com.melekhov.belltestbench.dto.OrderRequestDto;
import com.melekhov.belltestbench.dto.OrderIdResponseDto;
import com.melekhov.belltestbench.dto.OrderResponseDto;

public interface OrderService {
    public OrderIdResponseDto createOrder(OrderRequestDto orderRequestDto);
    public OrderResponseDto  getOrderById(Long orderId);
    public void deleteOrderById(Long orderId);
}
