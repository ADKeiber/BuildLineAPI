package com.pathfinderapps.buildlineapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name = "item_line")
public class ItemLine {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "item_line_id")
    private Long itemLineId;

    @Column(name = "description", unique = true)
    private String description;

    @ManyToOne(targetEntity=Customer.class, fetch = FetchType.EAGER)
    @JoinColumn(name="customer_id")
    private Customer customer;

}

