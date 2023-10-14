package com.pathfinderapps.buildlineapi.model;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "line")
public class Line {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "line_id")
    private Long lineId;

    @Column(name = "number_of_steps")
    private Integer numberOfSteps;

    @Column(name = "line_name")
    private String lineName;

    @Column(name = "stationIds")
    @ElementCollection
    private List<Long> stationIds;

}
