package com.examly.springapp.service;

import com.examly.springapp.model.PurchaseOrder;
import java.util.List;

public interface PurchaseOrderService {
    PurchaseOrder save(PurchaseOrder purchaseOrder);
    List<PurchaseOrder> findAll();
    PurchaseOrder findById(Long id);
    PurchaseOrder update(Long id, PurchaseOrder purchaseOrder);
    void deleteById(Long id);
}