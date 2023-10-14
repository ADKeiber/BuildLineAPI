package com.pathfinderapps.buildlineapi.service;

import com.pathfinderapps.buildlineapi.model.ItemLine;
import com.pathfinderapps.buildlineapi.model.ItemStatus;
import com.pathfinderapps.buildlineapi.repo.CustomerRepo;
import com.pathfinderapps.buildlineapi.repo.ItemLineRepo;
import com.pathfinderapps.buildlineapi.repo.ItemStatusRepo;
import com.pathfinderapps.buildlineapi.util.CustomerToItemLineForm;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class ItemLineService {

    private final ItemLineRepo repo;
    private final CustomerRepo customerRepo;

    public List<ItemLine> getAllItemLines(){
        log.info("Fetching all item statuses for admin");
        return repo.findAll();
    }

    public ItemLine createItemLine(ItemLine itemLine){
        log.info("Saving new item line {} to the database", itemLine.getDescription());
        return repo.save(itemLine);
    }

    public ItemLine addCustomerToItemLine(CustomerToItemLineForm form){
        log.info("Adding customer {} to the Item Line {} in the database", form.getCustomerName(), form.getItemLineDescription());
        ItemLine itemLine = repo.findItemLineByDescription(form.getItemLineDescription());
        itemLine.setCustomer(customerRepo.findCustomerByName(form.getCustomerName()));
        return repo.save(itemLine);
    }
}
