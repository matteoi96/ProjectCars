package com.comdata.car.service;

import org.springframework.data.domain.Page;

import com.comdata.car.model.Car;

public interface CarService {
	
	
	public Page<Car> getPage(int page,int items);
	
	
	
	public boolean add(Car car);
	
	public boolean update(Car car);
	
	public boolean delete(Car car);
	
	

	
}
