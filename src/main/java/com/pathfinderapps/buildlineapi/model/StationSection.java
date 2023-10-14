package com.pathfinderapps.buildlineapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Generated;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "station_section")
public class StationSection  {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "station_section_id")
    private Long stationSectionId;

    @Column(name = "description")
    private String description;

}
