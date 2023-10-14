package com.pathfinderapps.buildlineapi.repo;

import com.pathfinderapps.buildlineapi.model.Line;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LineRepo extends JpaRepository<Line, Long> {}
