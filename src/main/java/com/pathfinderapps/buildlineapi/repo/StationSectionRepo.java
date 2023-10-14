package com.pathfinderapps.buildlineapi.repo;

import com.pathfinderapps.buildlineapi.model.Station;
import com.pathfinderapps.buildlineapi.model.StationSection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StationSectionRepo extends JpaRepository<StationSection, Long> {}
