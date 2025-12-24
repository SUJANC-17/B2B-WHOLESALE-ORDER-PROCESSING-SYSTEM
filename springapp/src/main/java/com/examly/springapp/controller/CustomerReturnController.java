package com.examly.springapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.examly.springapp.model.CustomerReturn;
import com.examly.springapp.repository.CustomerReturnRepo;
import java.util.List;

@RestController
@RequestMapping("/api/customer-returns")
public class CustomerReturnController {
    
    @Autowired
    private CustomerReturnRepo customerReturnRepo;
    
    @PostMapping
    public ResponseEntity<CustomerReturn> create(@RequestBody CustomerReturn customerReturn) {
        return ResponseEntity.status(HttpStatus.CREATED).body(customerReturnRepo.save(customerReturn));
    }
    
    @GetMapping
    public List<CustomerReturn> getAll() {
        return customerReturnRepo.findAll();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<CustomerReturn> getById(@PathVariable Long id) {
        return customerReturnRepo.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<CustomerReturn> update(@PathVariable Long id, @RequestBody CustomerReturn customerReturn) {
        return customerReturnRepo.findById(id)
                .map(existing -> {
                    customerReturn.setCustomerReturnId(id);
                    return ResponseEntity.ok(customerReturnRepo.save(customerReturn));
                })
                .orElse(ResponseEntity.notFound().build());
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (customerReturnRepo.existsById(id)) {
            customerReturnRepo.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}