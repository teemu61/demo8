package com.example.demo8.domain;

import lombok.Data;

@Data
public class TireDTO {

    Long id;
    String malli;
    Integer hinta;
    CarDTO carDTO;

}
