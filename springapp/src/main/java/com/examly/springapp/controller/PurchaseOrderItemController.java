package com.examly.springapp.controller;

import com.examly.springapp.model.PurchaseOrderItem;
import com.examly.springapp.service.PurchaseOrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/purchase-orders-items")
@CrossOrigin
public class PurchaseOrderItemController {

    @Autowired
    private PurchaseOrderItemService purchaseOrderItemService;

    @GetMapping
    public List<PurchaseOrderItem> getAllPurchaseOrderItems() {
        return purchaseOrderItemService.findAll();
    }

    @GetMapping("/{id}")
    public PurchaseOrderItem getPurchaseOrderItemById(@PathVariable Long id) {
        return purchaseOrderItemService.findById(id);
    }

    @PostMapping
    public PurchaseOrderItem savePurchaseOrderItem(@RequestBody PurchaseOrderItem purchaseOrderItem) {
        return purchaseOrderItemService.save(purchaseOrderItem);
    }

    @DeleteMapping("/{id}")
    public void deletePurchaseOrderItem(@PathVariable Long id) {
        purchaseOrderItemService.deleteById(id);
    }
}