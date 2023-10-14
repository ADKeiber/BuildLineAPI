package com.pathfinderapps.buildlineapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name = "item_status")
public class ItemStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "item_status_id")
    private Long itemStatusId;

    @Column(name = "status")
    private String status;

}
