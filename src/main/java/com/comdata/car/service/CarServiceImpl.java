package com.comdata.car.service;



import java.util.Optional;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.comdata.car.model.Car;
import com.comdata.car.repository.CarRepository;

@Service
public class CarServiceImpl implements CarService {

	private CarRepository repository;
	private Logger logger = LoggerFactory.getLogger(CarServiceImpl.class);




	public CarServiceImpl(CarRepository repository) {

		this.repository = repository;
	}

	public Page<Car> getPage(int page, int elements) {
		try {
			return repository.findAll(PageRequest.of(page, elements));
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public boolean add(Car car) {

		try {
			logger.info("ADD CAR ");
			repository.save(car);
			return true;
		} catch (Exception e) {
			logger.error("VALIDATION NOT CORRECT");
			return false;
		}
	}

	@Override
	public boolean update(Car car) {

		try {
			logger.info("UPDATE CAR");
			repository.save(car);
			return true;
		} catch (Exception e) {
			logger.error("VALIDATION NOT CORRECT");
			return false;
		}
	}

	@Override
	public boolean delete(Car car) {
		try {
			logger.info("DELETE CAR");
			repository.delete(car);
			return true;
		} catch (Exception e) {
			logger.error("VALIDATION NOT CORRECT");

			return false;
		}

	}
	@Override
	public Car getById(UUID id) {
		try {
			Optional<Car> car =repository.findById(id);
			if(car.isPresent())
				return car.get();
			throw new Exception();
		} catch (Exception e) {
			return new Car();
		}
	
	}

	



}
