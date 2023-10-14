package com.pathfinderapps.buildlineapi.controller;

import com.pathfinderapps.buildlineapi.model.Item;
import com.pathfinderapps.buildlineapi.model.Line;
import com.pathfinderapps.buildlineapi.model.PurchaseOrder;
import com.pathfinderapps.buildlineapi.service.LineService;
import com.pathfinderapps.buildlineapi.util.ObjectsToItemForm;
import com.pathfinderapps.buildlineapi.util.StationToLineForm;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/line")
@RequiredArgsConstructor
public class LineController {

    private final LineService lineService;

    @GetMapping("/getAll")
    public ResponseEntity<List<Line>> getAllLines(){
        return ResponseEntity.ok().body(lineService.getAllLines());
    }

    @PostMapping("/create")
    public ResponseEntity<Line> saveRole(@RequestBody Line line){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/line/create").toUriString());
        return ResponseEntity.created(uri).body(lineService.createLine(line));
    }

    @PostMapping("/addStation")
    public ResponseEntity<Line> addObjectsToItem(@RequestBody StationToLineForm form){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/line/addStation").toUriString());
        return ResponseEntity.created(uri).body(lineService.addStationToLine(form));
    }
}
