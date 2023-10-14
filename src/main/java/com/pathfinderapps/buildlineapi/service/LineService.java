package com.pathfinderapps.buildlineapi.service;

import com.pathfinderapps.buildlineapi.model.Line;
import com.pathfinderapps.buildlineapi.model.PurchaseOrder;
import com.pathfinderapps.buildlineapi.model.Station;
import com.pathfinderapps.buildlineapi.repo.LineRepo;
import com.pathfinderapps.buildlineapi.repo.StationRepo;
import com.pathfinderapps.buildlineapi.util.StationToLineForm;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class LineService {

    private final LineRepo lineRepo;
    private final StationRepo stationRepo;

    public List<Line> getAllLines(){
        log.info("Fetching all lines for admin");
        return lineRepo.findAll();
    }

    public Line createLine(Line line){
        log.info("Saving new line {} to the database", line.getLineName());
        return lineRepo.save(line);
    }

    public Line addStationToLine(StationToLineForm form){
        log.info("Adding station with id {} to line with id {}", form.getStationId(), form.getLineId());
        Station station = stationRepo.findById(form.getStationId()).get();
        Line line = lineRepo.findById(form.getLineId()).get();
        line.getStationIds().add(1L);
        return lineRepo.save(line);
    }
}
