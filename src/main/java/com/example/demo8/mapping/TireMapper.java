package com.example.demo8.mapping;

import com.example.demo8.domain.Car;
import com.example.demo8.domain.CarDTO;
import com.example.demo8.domain.Tire;
import com.example.demo8.domain.TireDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface TireMapper {

    @Mapping(source="model", target="malli")
    @Mapping(source="price", target="hinta")
    TireDTO tireToTireDto(Tire tire);

    @Mapping(source="malli", target="model")
    @Mapping(source="hinta", target="price")
    Tire tireDtoToTire(TireDTO tireDTO);
}
