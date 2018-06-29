package com.inventory.vehicles.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.inventory.vehicles.entity.Vehicle;

public interface VehicleRepository extends CrudRepository<Vehicle, Long>{
	
	List<Vehicle> findByVehicleType(String vehicleType);
	
	List<Vehicle> findByStatus(String status);

}
