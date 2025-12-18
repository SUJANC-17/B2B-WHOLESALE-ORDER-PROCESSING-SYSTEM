package com.examly.springapp.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/suppliers")
public class SupplierController {
    
    @PostMapping
    public void create() {}
    
    @GetMapping("/{id}")
    public void getById(@PathVariable Long id) {}
}