package com.pathfinderapps.buildlineapi.repo;

import com.pathfinderapps.buildlineapi.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepo extends JpaRepository<Item, Long> {}
