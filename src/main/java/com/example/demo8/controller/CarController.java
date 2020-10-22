package com.example.demo8.controller;

import com.example.demo8.domain.Car;
import com.example.demo8.domain.CarDTO;
import com.example.demo8.mapping.CarMapper;
import com.example.demo8.service.CarService;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarController {

    CarService carService;
    CarMapper carMapper;

    public CarController(CarService carService, CarMapper carMapper) {
        this.carService = carService;
        this.carMapper = carMapper;
    }

    @GetMapping(value = "/all")
    @ResponseStatus(HttpStatus.OK)
    public List<CarDTO> getCars() {
        return carService.getCars().stream()
                .map(i -> carMapper.carToCarDto(i))
                .collect(Collectors.toList());
    }

    @PostMapping(value = "/add")
    public CarDTO addCar(@RequestBody CarDTO carDTO) {

        Car car = carMapper.carDtoToCar(carDTO);
        Car carSaved = carService.addCar(car);
        return carMapper.carToCarDto(carSaved);
    }



}
