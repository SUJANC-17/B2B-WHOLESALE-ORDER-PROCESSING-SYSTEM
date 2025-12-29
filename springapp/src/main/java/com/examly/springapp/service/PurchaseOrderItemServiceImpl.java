package com.examly.springapp.service;

import com.examly.springapp.model.PurchaseOrderItem;
import com.examly.springapp.repository.PurchaseOrderItemRepo;
import com.examly.springapp.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PurchaseOrderItemServiceImpl implements PurchaseOrderItemService {
    
    @Autowired
    private PurchaseOrderItemRepo purchaseOrderItemRepo;
    
    @Override
    public PurchaseOrderItem save(PurchaseOrderItem purchaseOrderItem) {
        return purchaseOrderItemRepo.save(purchaseOrderItem);
    }
    
    @Override
    public List<PurchaseOrderItem> findAll() {
        return purchaseOrderItemRepo.findAll();
    }
    
    @Override
    public PurchaseOrderItem findById(Long id) {
        PurchaseOrderItem item = purchaseOrderItemRepo.findById(id).orElse(null);
        if (item == null) {
            throw new ResourceNotFoundException("PurchaseOrderItem not found with id: " + id);
        }
        return item;
    }
    
    @Override
    public PurchaseOrderItem update(Long id, PurchaseOrderItem purchaseOrderItem) {
        if (!purchaseOrderItemRepo.existsById(id)) {
            throw new ResourceNotFoundException("PurchaseOrderItem not found with id: " + id);
        }
        purchaseOrderItem.setPurchaseOrderItemId(id);
        return purchaseOrderItemRepo.save(purchaseOrderItem);
    }
    
    @Override
    public void deleteById(Long id) {
        if (!purchaseOrderItemRepo.existsById(id)) {
            throw new ResourceNotFoundException("PurchaseOrderItem not found with id: " + id);
        }
        purchaseOrderItemRepo.deleteById(id);
    }
}