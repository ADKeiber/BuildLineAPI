package com.pathfinderapps.buildlineapi.controller;

import com.pathfinderapps.buildlineapi.model.Item;
import com.pathfinderapps.buildlineapi.model.ItemLine;
import com.pathfinderapps.buildlineapi.service.ItemLineService;
import com.pathfinderapps.buildlineapi.service.ItemService;
import com.pathfinderapps.buildlineapi.util.CustomerToItemLineForm;
import com.pathfinderapps.buildlineapi.util.ObjectsToItemForm;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/item")
@RequiredArgsConstructor
public class ItemController {

    private final ItemService service;

    @GetMapping("/getAll")
    public ResponseEntity<List<Item>> getAllItems(){
        return ResponseEntity.ok().body(service.getAllItem());
    }

    @PostMapping("/create")
    public ResponseEntity<Item> saveRole(@RequestBody Item item){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/itemStatus/create").toUriString());
        return ResponseEntity.created(uri).body(service.createItem(item));
    }

    @PostMapping("/addObjects")
    public ResponseEntity<Item> addObjectsToItem(@RequestBody ObjectsToItemForm form){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/customer/addCustomer").toUriString());
        return ResponseEntity.created(uri).body(service.addObjectsToItem(form));
    }
}
