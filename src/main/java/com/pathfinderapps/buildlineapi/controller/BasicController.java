package com.pathfinderapps.buildlineapi.controller;

import com.pathfinderapps.buildlineapi.model.Line;
import com.pathfinderapps.buildlineapi.model.Station;
import com.pathfinderapps.buildlineapi.service.BasicService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/basic")
@RequiredArgsConstructor
public class BasicController {

    private final BasicService basicService;

    @GetMapping("/create")
    public ResponseEntity<List<Line>> saveRole(){
        return ResponseEntity.ok().body(basicService.setupData());
    }
}
