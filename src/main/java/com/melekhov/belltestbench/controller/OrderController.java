package com.melekhov.belltestbench.controller;

import com.melekhov.belltestbench.dto.OrderRequestDto;
import com.melekhov.belltestbench.dto.OrderResponseDto;
import com.melekhov.belltestbench.service.OrderService;
import com.melekhov.belltestbench.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;
    private final ProductService productService;

    private static final String SESSION_HEADER = "X-session-id";

    @GetMapping("/getProducts")
    public ResponseEntity<Map<String, Integer>> getProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @PostMapping("/create")
    public ResponseEntity<?> createOrder(
            @RequestBody OrderRequestDto request)
    {
        try {
            OrderResponseDto orderResponse = orderService.createOrder(request);
            return ResponseEntity.ok(orderResponse);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/getOrder")
    public ResponseEntity<?> getOrder() {
        return ResponseEntity.ok().build();
    }

}
