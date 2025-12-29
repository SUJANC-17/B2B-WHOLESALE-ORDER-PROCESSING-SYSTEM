package com.examly.springapp.service;

import com.examly.springapp.model.Supplier;
import com.examly.springapp.repository.SupplierRepo;
import com.examly.springapp.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SupplierServiceImpl implements SupplierService {
    
    @Autowired
    private SupplierRepo supplierRepo;
    
    @Override
    public Supplier save(Supplier supplier) {
        return supplierRepo.save(supplier);
    }
    
    @Override
    public List<Supplier> findAll() {
        return supplierRepo.findAll();
    }
    
    @Override
    public Supplier findById(Long id) {
        Supplier supplier = supplierRepo.findById(id).orElse(null);
        if (supplier == null) {
            throw new ResourceNotFoundException("Supplier not found with id: " + id);
        }
        return supplier;
    }
    
    @Override
    public Supplier update(Long id, Supplier supplier) {
        if (!supplierRepo.existsById(id)) {
            throw new ResourceNotFoundException("Supplier not found with id: " + id);
        }
        supplier.setSupplierId(id);
        return supplierRepo.save(supplier);
    }
    
    @Override
    public void deleteById(Long id) {
        if (!supplierRepo.existsById(id)) {
            throw new ResourceNotFoundException("Supplier not found with id: " + id);
        }
        supplierRepo.deleteById(id);
    }
}