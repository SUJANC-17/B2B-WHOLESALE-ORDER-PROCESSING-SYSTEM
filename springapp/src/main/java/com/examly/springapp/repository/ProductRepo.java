package com.examly.springapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.examly.springapp.model.Product;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {
    Optional<Product> findByProductName(String productName);
    List<Product> findByPriceBetween(Double minPrice, Double maxPrice);
    List<Product> findByStockQuantityLessThan(Integer quantity);
}
