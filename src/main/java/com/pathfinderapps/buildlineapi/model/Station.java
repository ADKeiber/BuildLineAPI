package com.pathfinderapps.buildlineapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "station")
public class Station {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "station_id")
    private Long stationId;

    @OneToMany(targetEntity=Item.class,cascade = CascadeType.ALL , fetch = FetchType.EAGER)
    @JoinColumn(name="station_id")
    private List<Item> currentItems = new ArrayList<>();

    @OneToMany(targetEntity=Item.class,cascade = CascadeType.ALL , fetch = FetchType.EAGER)
    @JoinColumn(name="station_id")
    private List<Item> backlogItems;

    @OneToMany(targetEntity=Item.class,cascade = CascadeType.ALL , fetch = FetchType.EAGER)
    @JoinColumn(name="station_id")
    private List<Item> completedItems;

    @Column(name = "name")
    private String name;

    @Column(name = "warnings")
    private Integer warnings;

    @Column(name = "errors")
    private Integer errors;

    @Column(name = "station_worker")
    private String stationWorker;

    @ManyToOne(targetEntity=Line.class, fetch = FetchType.EAGER)
    @JoinColumn(name="line_id")
    private Line line;

}
