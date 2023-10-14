package com.pathfinderapps.buildlineapi.repo;

import com.pathfinderapps.buildlineapi.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepo  extends JpaRepository<Customer, Long> {
    Customer findCustomerByName(String name);
}