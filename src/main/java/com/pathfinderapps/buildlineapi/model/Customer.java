package com.pathfinderapps.buildlineapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.Set;


@Data
@Entity
@Table(name="customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "customer_id", unique = true)
    private Long customerId;

    @Column(name="name", nullable = false)
    private String name;

    @Column(name="address", nullable = false)
    private String address;

    @Column(name="phone_number", nullable = false)
    private String phoneNumber;

//    @JsonIgnore
//    @OneToMany(targetEntity=PurchaseOrder.class,cascade = CascadeType.ALL , fetch = FetchType.EAGER, mappedBy = "customer")
//    private Set<PurchaseOrder> purchaseOrders;
}
