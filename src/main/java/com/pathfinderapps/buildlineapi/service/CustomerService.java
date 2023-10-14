package com.pathfinderapps.buildlineapi.service;

import com.pathfinderapps.buildlineapi.model.Customer;
import com.pathfinderapps.buildlineapi.model.Line;
import com.pathfinderapps.buildlineapi.model.PurchaseOrder;
import com.pathfinderapps.buildlineapi.repo.CustomerRepo;
import com.pathfinderapps.buildlineapi.repo.PurchaseOrderRepo;
import com.pathfinderapps.buildlineapi.util.CustomerToPurchaseOrder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class CustomerService {

    private final CustomerRepo customerRepo;

    public List<Customer> getAllCustomers(){
        log.info("Fetching all customers for admin");
        return customerRepo.findAll();
    }

    public Customer createCustomer(Customer customer){
        log.info("Saving new customer {} to the database", customer.getName());
        return customerRepo.save(customer);
    }
}
