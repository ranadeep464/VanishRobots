package com.mission.VanishRobots.DAO;


import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Temporal;
import java.time.LocalDateTime;

@Data
public class Robot {
    private String model;
    private String serialNumber;
    private String manufacturedDate;
    private String category;
}
