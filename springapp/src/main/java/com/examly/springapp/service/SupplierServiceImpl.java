package com.examly.springapp.service;

import com.examly.springapp.model.Supplier;
import com.examly.springapp.repository.SupplierRepo;
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
        return supplierRepo.findById(id).orElse(null);
    }
    
    @Override
    public Supplier update(Long id, Supplier supplier) {
        supplier.setSupplierId(id);
        return supplierRepo.save(supplier);
    }
    
    @Override
    public void deleteById(Long id) {
        supplierRepo.deleteById(id);
    }
}