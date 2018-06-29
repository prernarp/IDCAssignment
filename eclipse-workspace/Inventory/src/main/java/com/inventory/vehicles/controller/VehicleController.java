package com.inventory.vehicles.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inventory.vehicles.entity.Vehicle;
import com.inventory.vehicles.repository.VehicleRepository;

@RestController
@RequestMapping("vehicle")
public class VehicleController {

	@Autowired
	VehicleRepository vehicleRepository;

	@PostMapping("/")
	public Vehicle add(@RequestBody Vehicle vehicle) {

		return vehicleRepository.save(vehicle);

	}

	@GetMapping("/")
	public List<Vehicle> getAll() {

		return (List<Vehicle>) vehicleRepository.findAll();

	}

	@GetMapping("/{id}")
	public Vehicle getOne(@PathVariable("id") long serialNumber) {

		return vehicleRepository.findById(serialNumber).get();

	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") long serialNumber) {

		vehicleRepository.deleteById(serialNumber);
	}
	
	@PutMapping("/{id}")
	public Vehicle update(@RequestBody Vehicle vehicle,@PathVariable("id") long serialNumber) {

		Vehicle old = vehicleRepository.findById(serialNumber).get();
		old.setModel(vehicle.getModel());
		old.setRegistrationDate(vehicle.getRegistrationDate());
		old.setStatus(vehicle.getStatus());
		old.setVehicleType(vehicle.getVehicleType());
		return vehicleRepository.save(old);

	}
	@GetMapping("/search/type/{type}")
	public List<Vehicle> byType(@PathVariable("type") String type){
		return vehicleRepository.findByVehicleType(type);
		
	}
	@GetMapping("/search/status/{status}")
	public List<Vehicle> byStatus(@PathVariable("status") String status){
		return vehicleRepository.findByStatus(status);
		
	}

}
