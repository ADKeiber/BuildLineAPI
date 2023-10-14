package com.pathfinderapps.buildlineapi.repo;

import com.pathfinderapps.buildlineapi.model.ItemStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemStatusRepo extends JpaRepository<ItemStatus, Long> {}