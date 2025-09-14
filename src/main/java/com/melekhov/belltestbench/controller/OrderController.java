package com.melekhov.belltestbench.controller;

import com.melekhov.belltestbench.dto.OrderRequestDto;
import com.melekhov.belltestbench.dto.OrderIdResponseDto;
import com.melekhov.belltestbench.dto.OrderResponseDto;
import com.melekhov.belltestbench.service.OrderService;
import com.melekhov.belltestbench.service.ProducerService;
import com.melekhov.belltestbench.service.ProductService;
import com.melekhov.belltestbench.service.SessionService;
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
    private final SessionService sessionService;
    private final ProducerService producerService;

    @GetMapping("/getProducts")
    public ResponseEntity<Map<String, Integer>> getProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @PostMapping("/create")
    public ResponseEntity<?> createOrder(
            @RequestBody OrderRequestDto request)
    {
        try {
            OrderIdResponseDto orderResponse = orderService.createOrder(request);
            return ResponseEntity.ok(orderResponse);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/getOrder/{id}")
    public ResponseEntity<?> getOrder(
            @PathVariable String id) {
        try {
            OrderResponseDto order = orderService.getOrderById(Long.parseLong(id));
            return ResponseEntity.ok(order);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Could not find order with id: " + id);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteOrder(
            @PathVariable String id
    ) {
        try {
            producerService.deleteOrderById(Long.parseLong(id));
            return ResponseEntity.accepted().body("Delete Order Successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Could not delete order with id: " + id);
        }
    }

}
