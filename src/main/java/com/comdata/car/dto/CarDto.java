package com.comdata.car.dto;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CarDto {
	
	@Id
	private UUID id;
	
	@NotNull
	@Size(min = 2, message="Enter at least two characters")
	@Column(name="brand")
	private String brand;
	
	
	@NotNull
	@Size(min = 2, message="Enter at least two characters")
	@Column(name="licenseplate", unique = true)
	private String licensePlate;
	
	
	


	public CarDto(String brand, String licensePlate) {
		super();
		setBrand(brand);
		setLicensePlate(licensePlate);
		
	}


	public CarDto() {
		super();
	}





	public String getBrand() {
		return brand;
	}


	public void setBrand(String brand) {
		this.brand = brand;
	}


	public String getLicensePlate() {
		return licensePlate;
	}


	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}
	
	
	
	
	
	
	
	

}
