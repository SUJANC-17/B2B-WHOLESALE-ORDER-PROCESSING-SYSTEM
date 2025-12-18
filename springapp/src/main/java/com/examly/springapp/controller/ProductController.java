package com.examly.springapp.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    
    @PostMapping
    public void create() {}
    
    @GetMapping
    public void getAll() {}
    
    @PutMapping("/{id}")
    public void update(@PathVariable Long id) {}
    
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {}
}