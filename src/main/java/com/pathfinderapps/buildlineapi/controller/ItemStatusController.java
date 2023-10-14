package com.pathfinderapps.buildlineapi.controller;

import com.pathfinderapps.buildlineapi.model.Customer;
import com.pathfinderapps.buildlineapi.model.ItemStatus;
import com.pathfinderapps.buildlineapi.service.CustomerService;
import com.pathfinderapps.buildlineapi.service.ItemStatusService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/itemStatus")
@RequiredArgsConstructor
public class ItemStatusController {

    private final ItemStatusService service;

    @GetMapping("/getAll")
    public ResponseEntity<List<ItemStatus>> getAllItemStatuses(){
        return ResponseEntity.ok().body(service.getAllItemStatuses());
    }

    @PostMapping("/create")
    public ResponseEntity<ItemStatus> saveRole(@RequestBody ItemStatus itemStatus){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/itemStatus/create").toUriString());
        return ResponseEntity.created(uri).body(service.createItemStatus(itemStatus));
    }
}
