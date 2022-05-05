package com.mission.VanishRobots.DAO;

import com.mission.VanishRobots.model.Survivor;
import lombok.Data;

import java.util.List;

@Data
public class Reports {
    private Float percentageOfInfectedSurvivors;
    private Float percentageOfNonInfectedSurvivors;
    private List<Survivor> infectedSurvivors;
    private List<Survivor> nonInfectedSurvivors;
    private Robot[] robots;

}
