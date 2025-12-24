package com.examly.springapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.examly.springapp.model.PurchaseOrderItem;
import com.examly.springapp.repository.PurchaseOrderItemRepo;
import java.util.List;

@RestController
@RequestMapping("/api/purchase-order-items")
public class PurchaseOrderItemController {
    
    @Autowired
    private PurchaseOrderItemRepo purchaseOrderItemRepo;
    
    @PostMapping
    public ResponseEntity<PurchaseOrderItem> create(@RequestBody PurchaseOrderItem purchaseOrderItem) {
        return ResponseEntity.status(HttpStatus.CREATED).body(purchaseOrderItemRepo.save(purchaseOrderItem));
    }
    
    @GetMapping
    public List<PurchaseOrderItem> getAll() {
        return purchaseOrderItemRepo.findAll();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<PurchaseOrderItem> getById(@PathVariable Long id) {
        return purchaseOrderItemRepo.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<PurchaseOrderItem> update(@PathVariable Long id, @RequestBody PurchaseOrderItem purchaseOrderItem) {
        return purchaseOrderItemRepo.findById(id)
                .map(existing -> {
                    purchaseOrderItem.setPurchaseOrderItemId(id);
                    return ResponseEntity.ok(purchaseOrderItemRepo.save(purchaseOrderItem));
                })
                .orElse(ResponseEntity.notFound().build());
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (purchaseOrderItemRepo.existsById(id)) {
            purchaseOrderItemRepo.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
    
    @GetMapping("/order/{orderId}")
    public List<PurchaseOrderItem> getByOrderId(@PathVariable Long orderId) {
        return purchaseOrderItemRepo.findByPurchaseOrderPurchaseOrderId(orderId);
    }
}