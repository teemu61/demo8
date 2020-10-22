package com.example.demo8.domain;

import javax.persistence.Entity;
import lombok.Builder;
import lombok.Data;

@Data
public class CarDTO {
    Long id;
    String malli;
}
