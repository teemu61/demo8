package com.example.demo8.controller;

import com.example.demo8.domain.Car;
import com.example.demo8.domain.CarDTO;
import com.example.demo8.mapping.CarMapper;
import com.example.demo8.service.CarService;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
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

        List<CarDTO> carDtoList = new ArrayList<>();

        List<Car> carList = carService.getCars();

        for (Car c: carList) {
            CarDTO carDTO = carMapper.carToCarDto(c);
            carDtoList.add(carDTO);
        }

        return carDtoList;
    }
}
