package com.example.demo8.client;

import com.example.demo8.domain.Car;
import com.example.demo8.domain.CarDTO;
import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CarClient {

    RestTemplate restTemplate;

    public CarClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<CarDTO> getAllCars() {

        final String url = "http://localhost:8080/all";

        CarDTO[] cars = restTemplate.getForObject(url,CarDTO[].class);
        return Arrays.asList(cars);

    }

    public CarDTO addCar(CarDTO carDTO) {

        final String url = "http://localhost:8080/add";
        return restTemplate.postForObject(url, carDTO, CarDTO.class);
    }

}
