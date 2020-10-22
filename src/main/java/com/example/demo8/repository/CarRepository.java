package com.example.demo8.repository;

import com.example.demo8.domain.Car;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CarRepository extends JpaRepository<Car, Long> {

    List<Car> findCarByModel(String model);

    @Query("SELECT c FROM Car c where c.price < ?1")
    List<Car> findCarsBelowPrice(Integer price);

}
