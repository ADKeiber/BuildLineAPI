package com.pathfinderapps.buildlineapi.controller;

import com.pathfinderapps.buildlineapi.model.Customer;
import com.pathfinderapps.buildlineapi.model.ItemLine;
import com.pathfinderapps.buildlineapi.model.ItemStatus;
import com.pathfinderapps.buildlineapi.model.PurchaseOrder;
import com.pathfinderapps.buildlineapi.service.CustomerService;
import com.pathfinderapps.buildlineapi.service.ItemStatusService;
import com.pathfinderapps.buildlineapi.service.PurchaseOrderService;
import com.pathfinderapps.buildlineapi.util.CustomerToItemLineForm;
import com.pathfinderapps.buildlineapi.util.CustomerToPurchaseOrder;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/purchaseOrder")
@RequiredArgsConstructor
public class PurchaseOrderController {

    private final PurchaseOrderService service;
//    private final CustomerService customerService;

    @GetMapping("/getAll")
    public ResponseEntity<List<PurchaseOrder>> getAllItemStatuses(){
        return ResponseEntity.ok().body(service.getAllPurchaseOrders());
    }

    @PostMapping("/create")
    public ResponseEntity<PurchaseOrder> saveRole(@RequestBody PurchaseOrder purchaseOrder){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/itemStatus/create").toUriString());
        return ResponseEntity.created(uri).body(service.createPurchaseOrder(purchaseOrder));
    }

    @PostMapping("/addCustomer")
    public ResponseEntity<PurchaseOrder> addCustomerToLine(@RequestBody CustomerToPurchaseOrder form){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/purchaseOrder/addCustomer").toUriString());
//        Customer customer = customerService.addPOToCustomer(form);
        return ResponseEntity.created(uri).body(service.addCustomerToPurchaseOrder(form));
    }
}
