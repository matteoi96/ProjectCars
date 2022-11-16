package com.comdata.car.repository;

import java.util.UUID;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.comdata.car.model.Car;

public interface CarRepository extends PagingAndSortingRepository<Car, UUID> {

}
