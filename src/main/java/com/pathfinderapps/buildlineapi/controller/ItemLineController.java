package com.pathfinderapps.buildlineapi.controller;

import com.pathfinderapps.buildlineapi.model.Customer;
import com.pathfinderapps.buildlineapi.model.ItemLine;
import com.pathfinderapps.buildlineapi.model.ItemStatus;
import com.pathfinderapps.buildlineapi.service.ItemLineService;
import com.pathfinderapps.buildlineapi.service.ItemStatusService;
import com.pathfinderapps.buildlineapi.util.CustomerToItemLineForm;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/itemLine")
@RequiredArgsConstructor
public class ItemLineController {

    private final ItemLineService service;

    @GetMapping("/getAll")
    public ResponseEntity<List<ItemLine>> getAllItemLines(){
        return ResponseEntity.ok().body(service.getAllItemLines());
    }

    @PostMapping("/create")
    public ResponseEntity<ItemLine> saveRole(@RequestBody ItemLine itemLine){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/itemStatus/create").toUriString());
        return ResponseEntity.created(uri).body(service.createItemLine(itemLine));
    }


    @PostMapping("/addCustomer")
    public ResponseEntity<ItemLine> addCustomerToLine(@RequestBody CustomerToItemLineForm form){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/customer/addCustomer").toUriString());
        return ResponseEntity.created(uri).body(service.addCustomerToItemLine(form));
    }
}
