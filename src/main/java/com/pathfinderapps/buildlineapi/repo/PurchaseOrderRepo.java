package com.pathfinderapps.buildlineapi.repo;

import com.pathfinderapps.buildlineapi.model.PurchaseOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseOrderRepo extends JpaRepository<PurchaseOrder, Long> {
    PurchaseOrder findPurchaseOrderByPurchaseOrderId(Long id);
}
