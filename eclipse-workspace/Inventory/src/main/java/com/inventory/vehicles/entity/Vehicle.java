package com.inventory.vehicles.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Vehicle {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long serialNumber;
	
	private String vehicleType;
	
	private String model;
	
	private String status;
	
	
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date registrationDate;


	public Long getSerialNumber() {
		return serialNumber;
	}


	public void setSerialNumber(Long serialNumber) {
		this.serialNumber = serialNumber;
	}


	public String getVehicleType() {
		return vehicleType;
	}


	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}


	public String getModel() {
		return model;
	}


	public void setModel(String model) {
		this.model = model;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public Date getRegistrationDate() {
		return registrationDate;
	}


	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}
	
	
	
	

}
