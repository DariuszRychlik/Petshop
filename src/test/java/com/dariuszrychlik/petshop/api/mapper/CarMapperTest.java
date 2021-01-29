package com.dariuszrychlik.petshop.api.mapper;

import com.dariuszrychlik.petshop.api.model.CarDTO;
import com.dariuszrychlik.petshop.domain.Car;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarMapperTest {

    CarMapper carMapper = CarMapper.INSTANCE;

    @Test
    void carToCarDTO() {
        //given
        Car car = new Car();
        car.setId(1L);
        car.setName("Car");
        car.setStatus("available");

        //when
        CarDTO carDTO = carMapper.carToCarDTO(car);

        //then
        assertEquals(Long.valueOf(1L), carDTO.getId());
        assertEquals("Car", carDTO.getName());
        assertEquals("available", carDTO.getStatus());

    }
}