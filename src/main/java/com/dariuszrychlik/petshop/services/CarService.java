package com.dariuszrychlik.petshop.services;

import com.dariuszrychlik.petshop.api.model.BoredDTO;
import com.dariuszrychlik.petshop.api.model.CarDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CarService {

    List<CarDTO> getAllCars();

    CarDTO getCarById(Long id);

    List<CarDTO> getCarByStatus(String status);

    CarDTO createNewCar(CarDTO carDTO);

    CarDTO updateCar(Long id, CarDTO carDTO);

    void deleteCarById(Long id);
}
