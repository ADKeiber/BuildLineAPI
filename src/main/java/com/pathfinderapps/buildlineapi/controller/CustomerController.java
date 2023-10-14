package com.pathfinderapps.buildlineapi.controller;

import com.pathfinderapps.buildlineapi.model.Customer;
import com.pathfinderapps.buildlineapi.service.CustomerService;
import com.pathfinderapps.buildlineapi.util.CustomerToPurchaseOrder;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping("/getAll")
    public ResponseEntity<List<Customer>> getAllCustomers(){
        return ResponseEntity.ok().body(customerService.getAllCustomers());
    }

    @PostMapping("/create")
    public ResponseEntity<Customer> saveRole(@RequestBody Customer customer){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/customer/create").toUriString());
        return ResponseEntity.created(uri).body(customerService.createCustomer(customer));
    }
}