package com.example.demo8.repository;

import com.example.demo8.domain.Car;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> {

    List<Car> findCarByModel(String model);

}
