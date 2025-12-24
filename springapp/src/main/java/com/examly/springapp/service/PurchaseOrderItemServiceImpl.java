package com.examly.springapp.service;

import com.examly.springapp.model.PurchaseOrderItem;
import com.examly.springapp.repository.PurchaseOrderItemRepo;
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
        return purchaseOrderItemRepo.findById(id).orElse(null);
    }
    
    @Override
    public PurchaseOrderItem update(Long id, PurchaseOrderItem purchaseOrderItem) {
        purchaseOrderItem.setPurchaseOrderItemId(id);
        return purchaseOrderItemRepo.save(purchaseOrderItem);
    }
    
    @Override
    public void deleteById(Long id) {
        purchaseOrderItemRepo.deleteById(id);
    }
}