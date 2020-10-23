package com.example.demo8.client;

import com.example.demo8.domain.Car;
import com.example.demo8.domain.CarDTO;
import com.example.demo8.service.CarService;
import java.util.List;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class CarClientTest {

    @Autowired
    CarClient carClient;

    @Autowired
    CarService carService;

    @Test
    void testGetAll() {

        carService.deleteAll();
        Car car1 = new Car();
        car1.setModel("volvo");
        car1.setPrice(10000);
        carService.addCar(car1);
        Car car2 = new Car();
        car2.setModel("lada");
        car2.setPrice(10000);
        carService.addCar(car2);

        List<CarDTO> allCars = carClient.getAllCars();
        assertEquals(2,allCars.size());
    }

    @Test
    void testCreate() {

        carService.deleteAll();
        CarDTO carDTO = new CarDTO();
        carDTO.setMalli("volvo");
        carDTO.setHinta(20000);

        carClient.addCar(carDTO);

        List<Car> cars = carService.getCars();
        assertEquals(1, cars.size());

    }
}