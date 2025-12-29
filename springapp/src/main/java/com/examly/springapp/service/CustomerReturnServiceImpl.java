package com.examly.springapp.service;

import com.examly.springapp.model.CustomerReturn;
import com.examly.springapp.repository.CustomerReturnRepo;
import com.examly.springapp.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CustomerReturnServiceImpl implements CustomerReturnService {
    
    @Autowired
    private CustomerReturnRepo customerReturnRepo;
    
    @Override
    public CustomerReturn save(CustomerReturn customerReturn) {
        return customerReturnRepo.save(customerReturn);
    }
    
    @Override
    public List<CustomerReturn> findAll() {
        return customerReturnRepo.findAll();
    }
    
    @Override
    public CustomerReturn findById(Long id) {
        CustomerReturn customerReturn = customerReturnRepo.findById(id).orElse(null);
        if (customerReturn == null) {
            throw new ResourceNotFoundException("CustomerReturn not found with id: " + id);
        }
        return customerReturn;
    }
    
    @Override
    public CustomerReturn update(Long id, CustomerReturn customerReturn) {
        if (!customerReturnRepo.existsById(id)) {
            throw new ResourceNotFoundException("CustomerReturn not found with id: " + id);
        }
        customerReturn.setCustomerReturnId(id);
        return customerReturnRepo.save(customerReturn);
    }
    
    @Override
    public void deleteById(Long id) {
        if (!customerReturnRepo.existsById(id)) {
            throw new ResourceNotFoundException("CustomerReturn not found with id: " + id);
        }
        customerReturnRepo.deleteById(id);
    }
}