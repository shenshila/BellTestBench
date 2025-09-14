package com.melekhov.belltestbench.service;

import java.util.Map;

public interface ProductService {
    public Map<String, Integer> getAllProducts();
    public Double getPrice(String productName);
}
