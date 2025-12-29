package com.examly.springapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.examly.springapp.model.PurchaseOrder;
import com.examly.springapp.service.PurchaseOrderService;
import java.util.List;

@RestController
@RequestMapping("/api/purchase-orders")
@CrossOrigin(origins = "*")
public class PurchaseOrderController {
    
    @Autowired
    private PurchaseOrderService purchaseOrderService;
    
    @PostMapping
    public ResponseEntity<PurchaseOrder> create(@RequestBody PurchaseOrder purchaseOrder) {
        return ResponseEntity.status(HttpStatus.CREATED).body(purchaseOrderService.save(purchaseOrder));
    }
    
    @GetMapping
    public List<PurchaseOrder> getAll() {
        return purchaseOrderService.findAll();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<PurchaseOrder> getById(@PathVariable Long id) {
        return ResponseEntity.ok(purchaseOrderService.findById(id));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<PurchaseOrder> update(@PathVariable Long id, @RequestBody PurchaseOrder purchaseOrder) {
        return ResponseEntity.ok(purchaseOrderService.update(id, purchaseOrder));
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        purchaseOrderService.deleteById(id);
        return ResponseEntity.ok().build();
    }
    
    @PatchMapping("/{id}")
    public ResponseEntity<PurchaseOrder> patch(@PathVariable Long id, @RequestBody PurchaseOrder purchaseOrder) {
        PurchaseOrder existing = purchaseOrderService.findById(id);
        if (purchaseOrder.getOrderNumber() != null) existing.setOrderNumber(purchaseOrder.getOrderNumber());
        if (purchaseOrder.getOrderDate() != null) existing.setOrderDate(purchaseOrder.getOrderDate());
        if (purchaseOrder.getStatus() != null) existing.setStatus(purchaseOrder.getStatus());
        if (purchaseOrder.getSupplier() != null) existing.setSupplier(purchaseOrder.getSupplier());
        return ResponseEntity.ok(purchaseOrderService.save(existing));
    }
}