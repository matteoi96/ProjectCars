package com.comdata.car.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.comdata.car.dto.CarDto;
import com.comdata.car.model.Car;
import com.comdata.car.service.CarService;


@RestController
public class CarController {

	private CarService carService;
	private ModelMapper modelMapper;

	public CarController(CarService carService, ModelMapper modelMapper) {
		super();
		this.carService = carService;
		this.modelMapper = modelMapper;
	}

	public Car carDtoToCar(CarDto carDto) {
		Car car = this.modelMapper.map(carDto, Car.class);
		return car;

	}
	public CarDto carToDto(Car car) {
		CarDto carDto =this.modelMapper.map(car, CarDto.class);
		return carDto;
	}

	@GetMapping("/page/{page}/items/{items}")
	public Page<CarDto> showAllCar(@PathVariable int page, @PathVariable int items) {
        Page<Car> listCar =carService.getPage(page, items);
        List<Car> cars=listCar.toList();
        List<CarDto> carsDto= new ArrayList<>();
        for(int i=0;i<cars.size();i++) {
            CarDto carDto = carToDto(cars.get(i));
            carsDto.add(carDto);            
        }
        Page<CarDto> pageCarDto= new PageImpl<>(carsDto, PageRequest.of(page, items), Long.valueOf(carsDto.size()) );
        return pageCarDto;
    }

	@PostMapping("/car")
	public boolean add(@Valid @RequestBody CarDto carDto) {
		Car car = carDtoToCar(carDto);

		return carService.add(car);
	}

	@PutMapping("/car")
	public boolean update(@Valid @RequestBody Car car) {
		return carService.update(car);
	}

	@DeleteMapping("/car")
	public boolean delete(@RequestBody Car car) {
		return carService.delete(car);

	}

}
