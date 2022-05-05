package com.mission.VanishRobots.repository;

import com.mission.VanishRobots.model.InfectionReport;
import com.mission.VanishRobots.model.Survivor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface InfectionReportRepository extends JpaRepository<InfectionReport,Long> {

    Optional<List<InfectionReport>> findByReportingSurvivor(Survivor reportingSurvivor);


}
