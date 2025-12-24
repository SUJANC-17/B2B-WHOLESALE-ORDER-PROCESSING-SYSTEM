package com.examly.springapp.service;

import com.examly.springapp.model.Product;
import com.examly.springapp.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    
    @Autowired
    private ProductRepo productRepo;
    
    @Override
    public Product save(Product product) {
        return productRepo.save(product);
    }
    
    @Override
    public List<Product> findAll() {
        return productRepo.findAll();
    }
    
    @Override
    public Product findById(Long id) {
        return productRepo.findById(id).orElse(null);
    }
    
    @Override
    public Product update(Long id, Product product) {
        product.setProductId(id);
        return productRepo.save(product);
    }
    
    @Override
    public void deleteById(Long id) {
        productRepo.deleteById(id);
    }
}