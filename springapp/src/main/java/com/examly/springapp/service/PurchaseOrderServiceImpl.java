package com.examly.springapp.service;

import com.examly.springapp.model.PurchaseOrder;
import com.examly.springapp.repository.PurchaseOrderRepo;
import com.examly.springapp.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PurchaseOrderServiceImpl implements PurchaseOrderService {
    
    @Autowired
    private PurchaseOrderRepo purchaseOrderRepo;
    
    @Override
    public PurchaseOrder save(PurchaseOrder purchaseOrder) {
        return purchaseOrderRepo.save(purchaseOrder);
    }
    
    @Override
    public List<PurchaseOrder> findAll() {
        return purchaseOrderRepo.findAll();
    }
    
    @Override
    public PurchaseOrder findById(Long id) {
        PurchaseOrder purchaseOrder = purchaseOrderRepo.findById(id).orElse(null);
        if (purchaseOrder == null) {
            throw new ResourceNotFoundException("PurchaseOrder not found with id: " + id);
        }
        return purchaseOrder;
    }
    
    @Override
    public PurchaseOrder update(Long id, PurchaseOrder purchaseOrder) {
        if (!purchaseOrderRepo.existsById(id)) {
            throw new ResourceNotFoundException("PurchaseOrder not found with id: " + id);
        }
        purchaseOrder.setPurchaseOrderId(id);
        return purchaseOrderRepo.save(purchaseOrder);
    }
    
    @Override
    public void deleteById(Long id) {
        if (!purchaseOrderRepo.existsById(id)) {
            throw new ResourceNotFoundException("PurchaseOrder not found with id: " + id);
        }
        purchaseOrderRepo.deleteById(id);
    }
}