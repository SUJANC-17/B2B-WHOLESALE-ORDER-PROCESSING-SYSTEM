package com.examly.springapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.examly.springapp.model.Supplier;
import com.examly.springapp.service.SupplierService;
import java.util.List;

@RestController
@RequestMapping("/api/suppliers")
@CrossOrigin(origins = "*")
public class SupplierController {
    
    @Autowired
    private SupplierService supplierService;
    
    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<Supplier> create(@RequestBody Supplier supplier) {
        return ResponseEntity.status(HttpStatus.CREATED).body(supplierService.save(supplier));
    }
    
    @GetMapping
    public List<Supplier> getAll() {
        return supplierService.findAll();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Supplier> getById(@PathVariable Long id) {
        return ResponseEntity.ok(supplierService.findById(id));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Supplier> update(@PathVariable Long id, @RequestBody Supplier supplier) {
        return ResponseEntity.ok(supplierService.update(id, supplier));
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        supplierService.deleteById(id);
        return ResponseEntity.ok().build();
    }
    
    @PatchMapping("/{id}")
    public ResponseEntity<Supplier> patch(@PathVariable Long id, @RequestBody Supplier supplier) {
        Supplier existing = supplierService.findById(id);
        if (supplier.getSupplierName() != null) existing.setSupplierName(supplier.getSupplierName());
        if (supplier.getContactNumber() != null) existing.setContactNumber(supplier.getContactNumber());
        if (supplier.getEmail() != null) existing.setEmail(supplier.getEmail());
        if (supplier.getAddress() != null) existing.setAddress(supplier.getAddress());
        return ResponseEntity.ok(supplierService.save(existing));
    }
}