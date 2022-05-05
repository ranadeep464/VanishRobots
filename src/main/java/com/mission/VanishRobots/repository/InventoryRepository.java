package com.mission.VanishRobots.repository;

import com.mission.VanishRobots.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {

}
