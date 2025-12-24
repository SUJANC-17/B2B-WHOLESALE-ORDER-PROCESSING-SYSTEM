package com.examly.springapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.examly.springapp.model.PurchaseOrder;
import com.examly.springapp.repository.PurchaseOrderRepo;
import java.util.List;

@RestController
@RequestMapping("/api/purchase-orders")
public class PurchaseOrderController {
    
    @Autowired
    private PurchaseOrderRepo purchaseOrderRepo;
    
    @PostMapping
    public ResponseEntity<PurchaseOrder> create(@RequestBody PurchaseOrder purchaseOrder) {
        return ResponseEntity.status(HttpStatus.CREATED).body(purchaseOrderRepo.save(purchaseOrder));
    }
    
    @GetMapping
    public List<PurchaseOrder> getAll() {
        return purchaseOrderRepo.findAll();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<PurchaseOrder> getById(@PathVariable Long id) {
        return purchaseOrderRepo.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<PurchaseOrder> update(@PathVariable Long id, @RequestBody PurchaseOrder purchaseOrder) {
        return purchaseOrderRepo.findById(id)
                .map(existing -> {
                    purchaseOrder.setPurchaseOrderId(id);
                    return ResponseEntity.ok(purchaseOrderRepo.save(purchaseOrder));
                })
                .orElse(ResponseEntity.notFound().build());
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (purchaseOrderRepo.existsById(id)) {
            purchaseOrderRepo.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}