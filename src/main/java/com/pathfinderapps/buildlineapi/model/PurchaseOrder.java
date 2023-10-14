package com.pathfinderapps.buildlineapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Generated;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "purchase_order")
public class PurchaseOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "purchase_order_id")
    private Long purchaseOrderId;

    @Column(name = "description")
    private String description;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "price")
    private Double price;

    @Column(name = "received_date")
    private Date receivedDate;

    @Column(name = "due_date")
    private Date dueDate;

    @Column(name = "completed_date")
    private Date completedDate;

    @ManyToOne(targetEntity=Customer.class, fetch = FetchType.EAGER)
    @JoinColumn(name="customer_id")
    private Customer customer;
}
