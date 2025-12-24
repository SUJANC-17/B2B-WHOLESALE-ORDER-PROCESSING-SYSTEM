package com.examly.springapp.service;

import com.examly.springapp.model.CustomerReturn;
import java.util.List;

public interface CustomerReturnService {
    CustomerReturn save(CustomerReturn customerReturn);
    List<CustomerReturn> findAll();
    CustomerReturn findById(Long id);
    CustomerReturn update(Long id, CustomerReturn customerReturn);
    void deleteById(Long id);
}