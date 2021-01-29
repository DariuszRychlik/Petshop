package com.dariuszrychlik.petshop.repositories;

import com.dariuszrychlik.petshop.domain.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long> {

    List<Car> getByStatus(String status);
}
