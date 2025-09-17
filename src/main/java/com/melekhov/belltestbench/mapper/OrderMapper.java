package com.melekhov.belltestbench.mapper;

import com.melekhov.belltestbench.dto.OrderRequestDto;
import com.melekhov.belltestbench.dto.OrderResponseDto;
import com.melekhov.belltestbench.model.Order;
import com.melekhov.belltestbench.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class OrderMapper {
    private final ProductService productService;

    public Order mapOrderRequestDtoToOrder(OrderRequestDto orderRequestDto) {
        Double price = productService.getPrice(orderRequestDto.getProductName());
        if (price == null) {
            throw new IllegalArgumentException("Product not found");
        }

        return Order.builder()
                .productName(orderRequestDto.getProductName())
                .quantity(orderRequestDto.getQuantity())
                .totalPrice(price * orderRequestDto.getQuantity())
//                .sessionId(UUID.fromString(orderRequestDto.getSessionId()))
                .build();
    }

    public OrderResponseDto mapOrderToOrderResponseDto(Order order) {
        return OrderResponseDto.builder()
                .orderId(order.getId())
                .productName(order.getProductName())
                .quantity(order.getQuantity())
                .totalPrice(order.getTotalPrice())
                .build();
    }

}
