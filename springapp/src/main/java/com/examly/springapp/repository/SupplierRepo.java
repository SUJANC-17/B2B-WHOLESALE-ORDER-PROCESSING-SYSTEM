package com.examly.springapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.examly.springapp.model.Supplier;
import java.util.Optional;

@Repository
public interface SupplierRepo extends JpaRepository<Supplier, Long> {
    Optional<Supplier> findBySupplierName(String supplierName);
    Optional<Supplier> findByEmail(String email);
    Optional<Supplier> findByContactNumber(String contactNumber);
}