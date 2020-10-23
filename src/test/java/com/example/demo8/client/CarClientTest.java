package com.example.demo8.client;

import com.example.demo8.domain.Car;
import com.example.demo8.domain.CarDTO;
import com.example.demo8.domain.Tire;
import com.example.demo8.service.CarService;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;
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

        //given
        carService.deleteAll();
        Car car = new Car();
        car.setModel("volvo");
        car.setPrice(10000);
        car.setTireList(new ArrayList<>());
        Tire tire = new Tire();
        tire.setModel("nokia");
        tire.setPrice(200);

        //create association on both directions!
        tire.setCar(car);
        car.getTireList().add(tire);

        //when
        Car carSaved = carService.addCar(car);

        //then
        assertNotNull(car);
        assertEquals("volvo", carSaved.getModel());
        assertEquals(200, car.getTireList().get(0).getPrice());
    }

    @Ignore
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