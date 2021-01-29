package com.dariuszrychlik.petshop.controllers;

import com.dariuszrychlik.petshop.api.model.CarDTO;
import com.dariuszrychlik.petshop.api.model.CarListDTO;
import com.dariuszrychlik.petshop.api.model.PetDTO;
import com.dariuszrychlik.petshop.api.model.PetListDTO;
import com.dariuszrychlik.petshop.services.CarService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/car/")
public class CarController {

    private final CarService carService;

    public CarController(CarService carService) {this.carService = carService; }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public CarDTO getCarById(@PathVariable Long id) {
        return carService.getCarById(id);
    }

    @GetMapping("findByStatus/{status}")
    public ResponseEntity<CarListDTO> getCarByStatus(@PathVariable String status) {
        return new ResponseEntity<CarListDTO>(
                new CarListDTO(carService.getCarByStatus(status)), HttpStatus.OK);

    }

    @PostMapping
    public ResponseEntity<CarDTO> createNewCar(@RequestBody CarDTO carDTO) {
        return new ResponseEntity<CarDTO>(carService.createNewCar(carDTO), HttpStatus.CREATED);

    }

    @PutMapping("{id}")
    public ResponseEntity<CarDTO> updateCar(@PathVariable Long id, @RequestBody CarDTO carDTO) {
        return new ResponseEntity<CarDTO>(carService.updateCar(id, carDTO), HttpStatus.OK);

    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteCar(@PathVariable Long id) {

        carService.deleteCarById(id);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
