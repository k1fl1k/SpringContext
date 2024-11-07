package com.k1fl1k.springcontexttest.repository;

import com.k1fl1k.springcontexttest.model.Product;
import jakarta.annotation.PostConstruct;
import java.math.BigDecimal;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.stereotype.Component;
import java.util.*;

@Component
public class ProductRepository {
    private final Map<Long, Product> productMap = new ConcurrentHashMap<>();

    @PostConstruct
    public void init() {
        saveOrUpdate(new Product(1L, "Product1", new BigDecimal("100.00")));
        saveOrUpdate(new Product(2L, "Product2", new BigDecimal("150.00")));
        saveOrUpdate(new Product(3L, "Product3", new BigDecimal("200.00")));
        saveOrUpdate(new Product(4L, "Product4", new BigDecimal("250.00")));
        saveOrUpdate(new Product(5L, "Product5", new BigDecimal("300.00")));
    }

    public List<Product> findAll() {
        return new ArrayList<>(productMap.values());
    }

    public void saveOrUpdate(Product product) {
        productMap.put(product.getId(), product);
    }

    public Product findById(Long id) {
        return productMap.get(id);
    }

    public void deleteById(Long id) {
        productMap.remove(id);
    }
}
