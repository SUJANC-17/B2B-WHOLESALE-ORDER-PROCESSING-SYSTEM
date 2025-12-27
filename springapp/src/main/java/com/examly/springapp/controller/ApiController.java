package com.examly.springapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiController {
    
    @GetMapping
    public String apiRoot() {
        return "API is running. Available endpoints: /api/products, /api/suppliers, /api/purchase-orders, /api/customer-returns, /api/purchase-order-items";
    }
}