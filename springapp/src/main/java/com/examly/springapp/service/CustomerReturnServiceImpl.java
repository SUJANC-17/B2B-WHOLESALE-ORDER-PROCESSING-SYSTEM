package com.examly.springapp.service;

import com.examly.springapp.model.CustomerReturn;
import com.examly.springapp.repository.CustomerReturnRepo;
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
        return customerReturnRepo.findById(id).orElse(null);
    }
    
    @Override
    public CustomerReturn update(Long id, CustomerReturn customerReturn) {
        customerReturn.setCustomerReturnId(id);
        return customerReturnRepo.save(customerReturn);
    }
    
    @Override
    public void deleteById(Long id) {
        customerReturnRepo.deleteById(id);
    }
}