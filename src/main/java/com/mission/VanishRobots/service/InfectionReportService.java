package com.mission.VanishRobots.service;

import com.mission.VanishRobots.model.InfectionReport;
import com.mission.VanishRobots.model.Survivor;
import com.mission.VanishRobots.repository.InfectionReportRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InfectionReportService {

    @Autowired
    InfectionReportRepository infectionReportRepository;

    @Autowired
    SurvivorService survivorService;

    public ResponseEntity<String> reportAndMarkInfection(InfectionReport infectionReport) {

        //check if the reporting survivor and infected survivor is existing. If exists check if reporting survivor is
        //reporting same infected person or not. if everything looks good mark the infection.

        Optional<Survivor> reportingSurvivor = survivorService.getById(infectionReport.getReportingSurvivor().getId());
        Optional<Survivor> infectedSurvivor = survivorService.getById(infectionReport.getInfectedSurvivor().getId());
        if (reportingSurvivor.isPresent() && infectedSurvivor.isPresent()) {
            Optional<List<InfectionReport>> infectionReports = infectionReportRepository.findByReportingSurvivor(reportingSurvivor.get());
            if (infectionReports.isPresent() && !infectionReports.get().isEmpty()){
                boolean alreadyReported = infectionReports.get().stream().anyMatch(infectionReport1 -> {
                    return infectionReport1.getInfectedSurvivor().getId() == infectionReport.getInfectedSurvivor().getId();
                });
                if (alreadyReported)
                    return new ResponseEntity<>(HttpStatus.ALREADY_REPORTED);
                else {
                    int infectionReportedCount = infectedSurvivor.get().getInfectionReportedCount();
                    infectedSurvivor.get().setInfectionReportedCount(infectionReportedCount+1);
                    if (infectedSurvivor.get().getInfectionReportedCount() >= 3)
                        infectedSurvivor.get().setInfected(true);
                    survivorService.addOrUpdateSurvivor(infectedSurvivor.get());
                    infectionReportRepository.save(infectionReport);
                    return new ResponseEntity<>(HttpStatus.CREATED);
                }
            } else {
                int infectionReportedCount = infectedSurvivor.get().getInfectionReportedCount();
                infectedSurvivor.get().setInfectionReportedCount(infectionReportedCount+1);
                if (infectedSurvivor.get().getInfectionReportedCount() >= 3)
                    infectedSurvivor.get().setInfected(true);
                survivorService.addOrUpdateSurvivor(infectedSurvivor.get());
                infectionReportRepository.save(infectionReport);
                return new ResponseEntity<>(HttpStatus.CREATED);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
