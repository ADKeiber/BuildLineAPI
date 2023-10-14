package com.pathfinderapps.buildlineapi.repo;

import com.pathfinderapps.buildlineapi.model.Station;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StationRepo extends JpaRepository<Station, Long> {}
