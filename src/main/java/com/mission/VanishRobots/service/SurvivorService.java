package com.mission.VanishRobots.service;

import com.mission.VanishRobots.model.Survivor;
import com.mission.VanishRobots.repository.SurvivorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SurvivorService {

    @Autowired
    SurvivorRepository survivorRepository;

    public void addOrUpdateSurvivor(Survivor survivor) {
        survivorRepository.save(survivor);
    }
     public Optional<Survivor> getById(Long id) {
          return survivorRepository.findById(id);
     }

     public List<Survivor> getAll(){
         return survivorRepository.findAll();
     }
}
