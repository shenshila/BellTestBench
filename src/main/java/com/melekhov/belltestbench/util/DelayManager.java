package com.melekhov.belltestbench.util;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
@Data
public class DelayManager {
    private final ConcurrentHashMap<String, Integer> delays = new ConcurrentHashMap<>();

    public DelayManager(
            @Value("${delay.session.create}") int sessionCreate,
            @Value("${delay.session.delete}") int sessionDelete,
            @Value("${delay.order.get-products}") int getProducts,
            @Value("${delay.order.create}") int orderCreate,
            @Value("${delay.order.get-order}") int getOrder,
            @Value("${delay.order.delete}") int orderDelete
    ) {
        delays.put("session.create", sessionCreate);
        delays.put("session.delete", sessionDelete);
        delays.put("order.get-products", getProducts);
        delays.put("order.create", orderCreate);
        delays.put("order.get-order", getOrder);
        delays.put("order.delete", orderDelete);
    }

    public int getDelay(String key) {
        return delays.get(key);
    }

    public Map<String, Integer> getAllDelays() {
        return Map.copyOf(delays);
    }

    public void updateDelay(String key, Integer delay) {
        delays.put(key, delay);
    }

}
