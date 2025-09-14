package com.melekhov.belltestbench.mapper;

import com.melekhov.belltestbench.dto.OrderRequestDto;
import com.melekhov.belltestbench.model.Order;
import com.melekhov.belltestbench.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

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
                .sessionId(orderRequestDto.getSessionId())
                .productName(orderRequestDto.getProductName())
                .quantity(orderRequestDto.getQuantity())
                .totalPrice(price * orderRequestDto.getQuantity())
                .build();
    }

}
