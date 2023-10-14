package com.pathfinderapps.buildlineapi.controller;

import com.pathfinderapps.buildlineapi.model.Customer;
import com.pathfinderapps.buildlineapi.model.StationSection;
import com.pathfinderapps.buildlineapi.service.CustomerService;
import com.pathfinderapps.buildlineapi.service.StationSectionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/stationSection")
@RequiredArgsConstructor
public class StationSectionController {

    private final StationSectionService service;

    @GetMapping("/getAll")
    public ResponseEntity<List<StationSection>> getAllCustomers(){
        return ResponseEntity.ok().body(service.getAllStationSections());
    }

    @PostMapping("/create")
    public ResponseEntity<StationSection> saveRole(@RequestBody StationSection stationSection){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/stationSection/create").toUriString());
        return ResponseEntity.created(uri).body(service.createStationSection(stationSection));
    }

}
