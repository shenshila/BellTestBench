package com.melekhov.belltestbench.service.impl;

import com.melekhov.belltestbench.service.ProductService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ConcurrentHashMap<String, Integer> products = new ConcurrentHashMap<>();

    @PostConstruct
    public void init(){
        products.put("apple", 70);
        products.put("banana", 60);
        products.put("chocolate", 100);
        products.put("bread", 40);
        products.put("milk", 90);
        products.put("butter", 77);
    }

    @Override
    public Map<String, Integer> getAllProducts() {
        return Map.copyOf(products);
    }

    public Double getPrice(String productName) {
        return Double.valueOf(products.get(productName));
    }
}
