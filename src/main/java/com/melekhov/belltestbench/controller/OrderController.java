package com.melekhov.belltestbench.controller;

import com.melekhov.belltestbench.dto.OrderRequestDto;
import com.melekhov.belltestbench.dto.OrderIdResponseDto;
import com.melekhov.belltestbench.dto.OrderResponseDto;
import com.melekhov.belltestbench.service.OrderService;
import com.melekhov.belltestbench.service.ProducerService;
import com.melekhov.belltestbench.service.ProductService;
import com.melekhov.belltestbench.service.SessionService;
import com.melekhov.belltestbench.util.DelayUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
@Log4j2
public class OrderController {
    private final OrderService orderService;
    private final ProductService productService;
    private final ProducerService producerService;
    private final DelayUtil delayUtil;

    @GetMapping("/getProducts")
    public ResponseEntity<Map<String, Integer>> getProducts() {
        delayUtil.applyDelay("order.get-products");
        log.info("get productsAAAAAAAAAAAAAAAAAAAA");
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @PostMapping("/create")
    public ResponseEntity<?> createOrder(
            @RequestBody OrderRequestDto request)
    {
        delayUtil.applyDelay("order.create");
        try {
            OrderIdResponseDto orderResponse = orderService.createOrder(request);
            log.info("Order createdAAAAAAAAAAAAAAa withID: {}", orderResponse.id());
            return ResponseEntity.ok(orderResponse);
        } catch (Exception e) {
            log.error(e.getMessage());
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/getOrder/{id}")
    public ResponseEntity<?> getOrder(
            @PathVariable String id) {
        delayUtil.applyDelay("order.get-order");
        try {
            log.info("AAAAAAAAAAAAAAAAAAAAget order");
            OrderResponseDto order = orderService.getOrderById(Long.parseLong(id));
            log.info("AAAAAAAAAAAAAAAAAAAAget order response: {}", order);
            return ResponseEntity.ok(order);
        } catch (Exception e) {
            log.error(e.getMessage());
            return ResponseEntity.badRequest().body("Could not find order with id: " + id);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteOrder(
            @PathVariable String id
    ) {
        delayUtil.applyDelay("order.delete");
        try {
            producerService.deleteOrderById(Long.parseLong(id));
            log.info("AAAAAAAAAAAAAAAAAAAAAaOrder with id: {} has been deleted", id);
            return ResponseEntity.accepted().body("Delete Order Successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Could not delete order with id: " + id);
        }
    }

}
