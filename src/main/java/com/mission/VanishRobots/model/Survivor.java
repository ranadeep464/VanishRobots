package com.mission.VanishRobots.model;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Data
public class Survivor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "Name cannot be empty")
    private String name;
    @NotEmpty(message = "Gender cannot be empty")
    private String gender;
    @NotNull(message = "Age cannot be empty")
    private Integer age;
    private String lastLocation;
    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinTable(name = "SurvivorInventory",
            joinColumns = @JoinColumn(name = "survivorId",referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "inventoryId", referencedColumnName = "id"))
    private List<Inventory> inventories;
    private int infectionReportedCount;
    private boolean infected;
}
