package com.pathfinderapps.buildlineapi.service;

import com.pathfinderapps.buildlineapi.model.Item;
import com.pathfinderapps.buildlineapi.model.ItemLine;
import com.pathfinderapps.buildlineapi.repo.*;
import com.pathfinderapps.buildlineapi.util.CustomerToItemLineForm;
import com.pathfinderapps.buildlineapi.util.ObjectsToItemForm;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class ItemService {

    private final ItemRepo repo;
    private final ItemLineRepo itemLineRepo;
    private final ItemStatusRepo itemStatusRepo;
    private final StationSectionRepo stationSectionRepo;
    private final StationRepo stationRepo;
    private final PurchaseOrderRepo purchaseOrderRepo;

    public List<Item> getAllItem(){
        log.info("Fetching all item statuses for admin");
        return repo.findAll();
    }

    public Item createItem(Item item){
        log.info("Saving new item {} to the database", item.getItemDescription());
        return repo.save(item);
    }

    public Item addObjectsToItem(ObjectsToItemForm form){
        log.info("Adding objects {} to the Item {} in the database", form, form.getItemId());
        Item item = repo.findById(form.getItemId()).get();
        item.setItemLine(itemLineRepo.findById(form.getItemLineId()).get());
        item.setItemStatus(itemStatusRepo.findById(form.getItemStatusId()).get());
        item.setStationSection(stationSectionRepo.findById(form.getStationSectionDescriptionId()).get());
//        item.setCurrentStation(stationRepo.findById(form.getStationId()).get());
        item.setPurchaseOrder(purchaseOrderRepo.findById(form.getPurchaseOrderId()).get());
        return repo.save(item);
    }
}
