package com.example.demo8.service;

import com.example.demo8.domain.Tire;
import com.example.demo8.repository.TireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TireService {

    @Autowired
    TireRepository tireRepository;

    public Tire getTireById(Long id) {
        return tireRepository.findById(id).get();
    }

}
