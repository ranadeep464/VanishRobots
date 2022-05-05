package com.mission.VanishRobots.controller;

import com.mission.VanishRobots.DAO.Reports;
import com.mission.VanishRobots.DAO.Robot;
import com.mission.VanishRobots.model.InfectionReport;
import com.mission.VanishRobots.model.Survivor;
import com.mission.VanishRobots.service.InfectionReportService;
import com.mission.VanishRobots.service.SurvivorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class SurvivorController {

    @Autowired
    SurvivorService survivorService;

    @Autowired
    InfectionReportService infectionReportService;

    @PostMapping("/addSurvivor")
    public ResponseEntity<String> addSurvivor(@Valid @RequestBody Survivor survivor) {
        survivorService.addOrUpdateSurvivor(survivor);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PatchMapping("/updateSurvivorLocation/{id}")
    public ResponseEntity<String> updateLocation(@PathVariable Long id, @RequestParam String latitudeLongitude) {
        Optional<Survivor> survivor = survivorService.getById(id);
        if (survivor.isPresent()) {
            survivor.get().setLastLocation(latitudeLongitude);
            survivorService.addOrUpdateSurvivor(survivor.get());
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/reportInfection")
    public ResponseEntity<String> reportInfection(@RequestParam Long reportingSurvivorId, @RequestParam Long infectedSurvivorId) {

        //check service class for business logic
        Optional<Survivor> reportingSurvivor = survivorService.getById(reportingSurvivorId);
        Optional<Survivor> infectedSurvivor = survivorService.getById(infectedSurvivorId);
        if(reportingSurvivor.isPresent() && infectedSurvivor.isPresent()){
            InfectionReport infectionReport = new InfectionReport();
            infectionReport.setInfectedSurvivor(infectedSurvivor.get());
            infectionReport.setReportingSurvivor(reportingSurvivor.get());
            return infectionReportService.reportAndMarkInfection(infectionReport);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @GetMapping("/reports")
    public ResponseEntity<Reports> getReports(){
        Reports reports = new Reports();
        Robot[] robots = getRobots();
        reports.setRobots(robots);
        getInfectedAndNonInfectedData(reports);
        return new ResponseEntity<>(reports,HttpStatus.OK);
    }

    private Robot[] getRobots(){
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject("https://robotstakeover20210903110417.azurewebsites.net/robotcpu", Robot[].class);
    }

    private void getInfectedAndNonInfectedData(Reports reports){
        List<Survivor> survivors = survivorService.getAll();
        List<Survivor> infectedSurvivors = survivors.stream().filter(Survivor::isInfected).collect(Collectors.toList());
        List<Survivor> nonInfectedSurvivors = survivors.stream().filter(survivor -> !survivor.isInfected()).collect(Collectors.toList());
        Float percentageOfInfectedSurvivors = (float) (!survivors.isEmpty() ? ((float)infectedSurvivors.size() / survivors.size()) * 100 : 0);
        Float percentageOfNonInfectedSurvivors = (float) (!survivors.isEmpty() ? ((float)nonInfectedSurvivors.size() / survivors.size()) * 100 : 0);
        reports.setNonInfectedSurvivors(nonInfectedSurvivors);
        reports.setInfectedSurvivors(infectedSurvivors);
        reports.setPercentageOfInfectedSurvivors(percentageOfInfectedSurvivors);
        reports.setPercentageOfNonInfectedSurvivors(percentageOfNonInfectedSurvivors);
    }

}
