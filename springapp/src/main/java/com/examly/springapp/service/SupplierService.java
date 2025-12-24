package com.examly.springapp.service;

import com.examly.springapp.model.Supplier;
import java.util.List;

public interface SupplierService {
    Supplier save(Supplier supplier);
    List<Supplier> findAll();
    Supplier findById(Long id);
    Supplier update(Long id, Supplier supplier);
    void deleteById(Long id);
}