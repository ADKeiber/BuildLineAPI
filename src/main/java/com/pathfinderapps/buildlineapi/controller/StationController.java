package com.pathfinderapps.buildlineapi.controller;

import com.pathfinderapps.buildlineapi.model.Station;
import com.pathfinderapps.buildlineapi.model.StationSection;
import com.pathfinderapps.buildlineapi.service.StationSectionService;
import com.pathfinderapps.buildlineapi.service.StationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/station")
@RequiredArgsConstructor
public class StationController {
    private final StationService service;

    @GetMapping("/getAll")
    public ResponseEntity<List<Station>> getAllStations(){
        return ResponseEntity.ok().body(service.getAllStations());
    }

    @PostMapping("/create")
    public ResponseEntity<Station> saveRole(@RequestBody Station station){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/station/create").toUriString());
        return ResponseEntity.created(uri).body(service.createStation(station));
    }

//    @PostMapping("/{stationId}/addItemLine/{itemLineDescription}")
//    public ResponseEntity<Station> saveRole(@PathVariable Long stationId, @PathVariable String itemLineDescription){
//        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/station/{stationId}/addLine/{lineDescription}").toUriString());
//        return ResponseEntity.created(uri).body(service.addLineToStation(stationId, itemLineDescription));
//    }
}
