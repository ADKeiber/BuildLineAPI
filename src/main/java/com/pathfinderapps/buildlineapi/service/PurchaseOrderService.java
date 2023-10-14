package com.pathfinderapps.buildlineapi.service;

import com.pathfinderapps.buildlineapi.model.Customer;
import com.pathfinderapps.buildlineapi.model.PurchaseOrder;
import com.pathfinderapps.buildlineapi.model.StationSection;
import com.pathfinderapps.buildlineapi.repo.CustomerRepo;
import com.pathfinderapps.buildlineapi.repo.PurchaseOrderRepo;
import com.pathfinderapps.buildlineapi.repo.StationSectionRepo;
import com.pathfinderapps.buildlineapi.util.CustomerToPurchaseOrder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class PurchaseOrderService {
    private final PurchaseOrderRepo repo;
    private final CustomerRepo customerRepo;
    public List<PurchaseOrder> getAllPurchaseOrders(){
        log.info("Fetching all purchase orders for admin");
        return repo.findAll();
    }

    public PurchaseOrder createPurchaseOrder(PurchaseOrder purchaseOrder){
        log.info("Saving new purchase order {} to the database", purchaseOrder.getDescription());
        return repo.save(purchaseOrder);
    }

    public PurchaseOrder addCustomerToPurchaseOrder(CustomerToPurchaseOrder form){
        log.info("Saving customer {} to the purchase order id {} in the database", form.getCustomerName(), form.getPoId());
        Customer customer = customerRepo.findCustomerByName(form.getCustomerName());
        PurchaseOrder po = repo.findPurchaseOrderByPurchaseOrderId(form.getPoId());
        log.info("Customer info: " + customer.toString());
        po.setCustomer(customer);
        return repo.save(po);
    }
}
