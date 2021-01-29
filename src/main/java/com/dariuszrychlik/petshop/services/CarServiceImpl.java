package com.dariuszrychlik.petshop.services;

import com.dariuszrychlik.petshop.api.mapper.CarMapper;
import com.dariuszrychlik.petshop.api.model.CarDTO;
import com.dariuszrychlik.petshop.domain.Car;
import com.dariuszrychlik.petshop.repositories.CarRepository;
import org.springframework.stereotype.Service;

import java.io.CharArrayReader;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarServiceImpl implements CarService {

    CarRepository carRepository;
    CarMapper carMapper;

    public CarServiceImpl(CarRepository carRepository, CarMapper carMapper) {
        this.carRepository = carRepository;
        this.carMapper = carMapper;
    }

    @Override
    public List<CarDTO> getAllCars() {
        return carRepository.findAll()
                .stream()
                .map(carMapper::carToCarDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CarDTO getCarById(Long id) { return carMapper.carToCarDTO(carRepository.findById(id).get());
    }

    @Override
    public List<CarDTO> getCarByStatus(String status) {
        return carRepository.getByStatus(status)
                .stream()
                .map(carMapper::carToCarDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CarDTO createNewCar(CarDTO carDTO) {

        Car car = carMapper.carDTOToCar(carDTO);
        Car savedCar = carRepository.save(car);

        return carMapper.carToCarDTO(savedCar);
    }

    @Override
    public CarDTO updateCar(Long id, CarDTO carDTO) {

        Car car = carMapper.carDTOToCar(carDTO);
        car.setId(id);

        Car savedCar = carRepository.save(car);

        return carMapper.carToCarDTO(savedCar);
    }

    @Override
    public void deleteCarById(Long id) { carRepository.deleteById(id);}
}
