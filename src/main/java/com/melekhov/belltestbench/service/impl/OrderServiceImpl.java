package com.melekhov.belltestbench.service.impl;

import com.melekhov.belltestbench.dto.OrderRequestDto;
import com.melekhov.belltestbench.dto.OrderIdResponseDto;
import com.melekhov.belltestbench.dto.OrderResponseDto;
import com.melekhov.belltestbench.mapper.OrderMapper;
import com.melekhov.belltestbench.model.Order;
import com.melekhov.belltestbench.repository.OrderRepository;
import com.melekhov.belltestbench.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    @Override
    public OrderIdResponseDto createOrder(OrderRequestDto orderRequestDto) {
        Order order = orderMapper.mapOrderRequestDtoToOrder(orderRequestDto);
        orderRepository.save(order);
        return new OrderIdResponseDto(order.getId());
    }

    @Override
    public OrderResponseDto getOrderById(Long orderId) {
        Order order = orderRepository.getReferenceById(orderId);

        return orderMapper.mapOrderToOrderResponseDto(order);
    }

    @Override
    public void deleteOrderById(Long orderId) {
        orderRepository.deleteById(orderId);
    }
}
