package com.example.demo8.domain;

import java.util.List;
import javax.persistence.Entity;
import lombok.Builder;
import lombok.Data;

@Data
public class CarDTO {
    Long id;
    String malli;
    Integer hinta;
    List<Tire> tireList;
}
