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
        return carRepository.findAll();
    }

    public Car addCar(Car car) {
        return carRepository.save(car);
    }

    public List<Car> findCarByModel(String model) {
        return carRepository.findCarByModel(model);
    }

    public List<Car> findCarsBelowPrice(Integer price) {
        return carRepository.findCarsBelowPrice(price);
    }

    public void deleteAll() {

        carRepository.findAll().forEach(i -> carRepository.delete(i));
        carRepository.flush();

    }

}
