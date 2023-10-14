package com.pathfinderapps.buildlineapi.model;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "item")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "item_id")
    private Long itemId;

    @Column(name = "name")
    private String name;

    @Column(name = "color")
    private String color;

    @Column(name = "part_quantity")
    private Integer partQuantity;

    @Column(name = "item_description")
    private String itemDescription;

    @Column(name = "warning_in_seconds")
    private Long warningInSeconds;

    @Column(name = "error_in_seconds")
    private Long errorInSeconds;

    @Column(name = "time_in_station")
    private Date timeEnteredArea;

    @ManyToOne(targetEntity=ItemLine.class, fetch = FetchType.EAGER)
    @JoinColumn(name="item_line_id")
    private ItemLine itemLine;

    @ManyToOne(targetEntity=ItemStatus.class, fetch = FetchType.EAGER)
    @JoinColumn(name="item_status_id")
    private ItemStatus itemStatus;

    @ManyToOne(targetEntity=PurchaseOrder.class, fetch = FetchType.EAGER)
    @JoinColumn(name="purchase_order_id")
    private PurchaseOrder purchaseOrder;

    @ManyToOne(targetEntity=StationSection.class, fetch = FetchType.EAGER)
    @JoinColumn(name="station_section_id")
    private StationSection stationSection;

}
