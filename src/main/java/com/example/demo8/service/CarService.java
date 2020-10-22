package com.example.demo8.service;

import com.example.demo8.domain.Car;
import com.example.demo8.repository.CarRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class CarService {

    CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List<Car> getCars() {
        return carRepository.findAll();
    }

}
