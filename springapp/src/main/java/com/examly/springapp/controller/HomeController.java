package com.examly.springapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    
    @GetMapping("/")
    public String home() {
        return "<h1>Spring Boot API Endpoints</h1>" +
               "<h3>Product Endpoints:</h3>" +
               "<ul>" +
               "<li>GET /api/products - Get all products</li>" +
               "<li>GET /api/products/{id} - Get product by ID</li>" +
               "<li>POST /api/products - Create product</li>" +
               "<li>PUT /api/products/{id} - Update product</li>" +
               "<li>DELETE /api/products/{id} - Delete product</li>" +
               "</ul>" +
               "<h3>Supplier Endpoints:</h3>" +
               "<ul>" +
               "<li>GET /api/suppliers - Get all suppliers</li>" +
               "<li>GET /api/suppliers/{id} - Get supplier by ID</li>" +
               "<li>POST /api/suppliers - Create supplier</li>" +
               "<li>PUT /api/suppliers/{id} - Update supplier</li>" +
               "<li>DELETE /api/suppliers/{id} - Delete supplier</li>" +
               "</ul>" +
               "<h3>Purchase Order Endpoints:</h3>" +
               "<ul>" +
               "<li>GET /api/purchase-orders - Get all purchase orders</li>" +
               "<li>GET /api/purchase-orders/{id} - Get purchase order by ID</li>" +
               "<li>POST /api/purchase-orders - Create purchase order</li>" +
               "<li>PUT /api/purchase-orders/{id} - Update purchase order</li>" +
               "<li>DELETE /api/purchase-orders/{id} - Delete purchase order</li>" +
               "</ul>" +
               "<h3>Customer Return Endpoints:</h3>" +
               "<ul>" +
               "<li>GET /api/customer-returns - Get all customer returns</li>" +
               "<li>GET /api/customer-returns/{id} - Get customer return by ID</li>" +
               "<li>POST /api/customer-returns - Create customer return</li>" +
               "<li>PUT /api/customer-returns/{id} - Update customer return</li>" +
               "<li>DELETE /api/customer-returns/{id} - Delete customer return</li>" +
               "</ul>" +
               "<h3>Purchase Order Item Endpoints:</h3>" +
               "<ul>" +
               "<li>GET /api/purchase-order-items/order/{orderId} - Get items by order ID</li>" +
               "<li>POST /api/purchase-order-items - Create purchase order item</li>" +
               "</ul>";
    }
}