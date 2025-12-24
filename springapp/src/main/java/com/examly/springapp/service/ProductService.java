package com.examly.springapp.service;

import com.examly.springapp.model.Product;
import java.util.List;

public interface ProductService {
    Product save(Product product);
    List<Product> findAll();
    Product findById(Long id);
    Product update(Long id, Product product);
    void deleteById(Long id);
}