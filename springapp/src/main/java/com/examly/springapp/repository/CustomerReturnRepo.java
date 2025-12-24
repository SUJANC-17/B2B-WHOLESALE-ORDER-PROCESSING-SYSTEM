package com.examly.springapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.examly.springapp.model.CustomerReturn;
import java.util.List;

@Repository
public interface CustomerReturnRepo extends JpaRepository<CustomerReturn, Long> {
    List<CustomerReturn> findByProductProductId(Long productId);
    List<CustomerReturn> findByReason(String reason);
}
