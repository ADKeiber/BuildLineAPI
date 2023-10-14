package com.pathfinderapps.buildlineapi.service;

import com.pathfinderapps.buildlineapi.model.Customer;
import com.pathfinderapps.buildlineapi.model.Line;
import com.pathfinderapps.buildlineapi.model.StationSection;
import com.pathfinderapps.buildlineapi.repo.LineRepo;
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
public class StationSectionService {

    private final StationSectionRepo repo;

    public List<StationSection> getAllStationSections(){
        log.info("Fetching all station sections for admin");
        return repo.findAll();
    }

    public StationSection createStationSection(StationSection stationSection){
        log.info("Saving new station section {} to the database", stationSection.getDescription());
        return repo.save(stationSection);
    }
}
