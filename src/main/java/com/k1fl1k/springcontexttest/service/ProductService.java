package com.k1fl1k.springcontexttest.service;

import com.k1fl1k.springcontexttest.model.Product;
import java.util.List;

public interface ProductService {

    List<Product> getProductList();
    void saveOrUpdate(Product product);
    Product getProductById(Long id);
    void deleteById(Long id);
}
