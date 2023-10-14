package com.pathfinderapps.buildlineapi.repo;

import com.pathfinderapps.buildlineapi.model.ItemLine;
import com.pathfinderapps.buildlineapi.model.StationSection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemLineRepo  extends JpaRepository<ItemLine, Long> {
    ItemLine findItemLineByDescription(String description);
}