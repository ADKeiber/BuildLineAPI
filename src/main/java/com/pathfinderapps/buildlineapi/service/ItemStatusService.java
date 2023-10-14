package com.pathfinderapps.buildlineapi.service;

import com.pathfinderapps.buildlineapi.model.ItemStatus;
import com.pathfinderapps.buildlineapi.model.StationSection;
import com.pathfinderapps.buildlineapi.repo.ItemStatusRepo;
import com.pathfinderapps.buildlineapi.repo.StationSectionRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class ItemStatusService {

    private final ItemStatusRepo repo;

    public List<ItemStatus> getAllItemStatuses(){
        log.info("Fetching all item statuses for admin");
        return repo.findAll();
    }

    public ItemStatus createItemStatus(ItemStatus itemStatus){
        log.info("Saving new item status {} to the database", itemStatus.getStatus());
        return repo.save(itemStatus);
    }
}
