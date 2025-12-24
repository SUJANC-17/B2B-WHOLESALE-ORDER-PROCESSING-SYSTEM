package com.examly.springapp.service;

import com.examly.springapp.model.PurchaseOrderItem;
import java.util.List;

public interface PurchaseOrderItemService {
    PurchaseOrderItem save(PurchaseOrderItem purchaseOrderItem);
    List<PurchaseOrderItem> findAll();
    PurchaseOrderItem findById(Long id);
    PurchaseOrderItem update(Long id, PurchaseOrderItem purchaseOrderItem);
    void deleteById(Long id);
}