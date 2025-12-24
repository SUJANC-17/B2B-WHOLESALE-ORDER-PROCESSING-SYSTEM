package com.examly.springapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.examly.springapp.model.PurchaseOrder;
import java.util.List;
import java.util.Optional;

@Repository
public interface PurchaseOrderRepo extends JpaRepository<PurchaseOrder, Long> {
    Optional<PurchaseOrder> findByOrderNumber(String orderNumber);
    List<PurchaseOrder> findByStatus(String status);
    List<PurchaseOrder> findBySupplierSupplierId(Long supplierId);
}
