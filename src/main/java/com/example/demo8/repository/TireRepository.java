package com.example.demo8.repository;

import com.example.demo8.domain.Tire;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TireRepository extends JpaRepository<Tire, Long> {
}
