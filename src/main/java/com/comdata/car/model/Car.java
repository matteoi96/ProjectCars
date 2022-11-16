package com.comdata.car.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name= "cars")
public class Car {
	
	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	private UUID id;
	
	@NotNull
	@Size(min = 2, message="Enter at least two characters")
	@Column(name="brand")
	private String brand;
	
	
	@NotNull
	@Size(min = 2, message="Enter at least two characters")
	@Column(name="licenseplate", unique = true)
	private String licensePlate;


	//Constructor with parameters
	public Car(String brand, String licensePlate) {
		super();
		this.brand = brand;
		this.licensePlate = licensePlate;
	}

	//Constructor default
	public Car() {
		super();
	}

	
	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
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
