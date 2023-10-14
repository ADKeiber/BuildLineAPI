package com.pathfinderapps.buildlineapi.service;

import com.pathfinderapps.buildlineapi.model.ItemLine;
import com.pathfinderapps.buildlineapi.model.Station;
import com.pathfinderapps.buildlineapi.model.StationSection;
import com.pathfinderapps.buildlineapi.repo.ItemLineRepo;
import com.pathfinderapps.buildlineapi.repo.StationRepo;
import com.pathfinderapps.buildlineapi.repo.StationSectionRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class StationService {

    private final StationRepo repo;

    public List<Station> getAllStations(){
        log.info("Fetching all station sections for admin");
        return repo.findAll();
    }

    public Station createStation(Station station){
        log.info("Saving new station {} to the database", station.getName());
        return repo.save(station);
    }

//    public Station addLineToStation(long stationId, long lineID){
//        log.info("Adding line with id {} to station with id {} the database", lineID, stationId);
//        Optional<Station> optionalStation = repo.findById(stationId);
//        Station station;
//        if(optionalStation.isPresent()){
//            ItemLine itemLine = itemLineRepo.findItemLineByDescription(itemLineDescription);
//            optionalStation.get().setLine(itemLine);
//        }
//
//
//        return station.map(repo::save).orElse(null);
//    }
}
