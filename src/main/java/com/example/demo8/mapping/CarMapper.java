package com.example.demo8.mapping;

import com.example.demo8.domain.Car;
import com.example.demo8.domain.CarDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CarMapper {

    @Mapping(source="model", target="malli")
    CarDTO carToCarDto(Car car);

    @Mapping(source="malli", target="model")
    Car carDtoToCar(CarDTO carDTO);

}
