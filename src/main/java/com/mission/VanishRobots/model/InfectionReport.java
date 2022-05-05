package com.mission.VanishRobots.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class InfectionReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.EAGER)
    private Survivor reportingSurvivor;
    @ManyToOne(fetch = FetchType.EAGER)
    private Survivor infectedSurvivor;
}
