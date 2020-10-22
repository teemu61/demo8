package com.example.demo8.service;

import com.example.demo8.domain.Car;
import com.example.demo8.domain.CarDTO;
import com.example.demo8.mapping.CarMapper;
import com.example.demo8.mapping.CarMapperImpl;
import com.example.demo8.repository.CarRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class CarService {

    CarRepository carRepository;

    CarMapper carMapper;

    public CarService(CarRepository carRepository, CarMapper carMapper) {
        this.carRepository = carRepository;
        this.carMapper = carMapper;
    }

    public List<Car> getCars() {

        List<Car> carList = carRepository.findAll();
        return carList;
    }

}
