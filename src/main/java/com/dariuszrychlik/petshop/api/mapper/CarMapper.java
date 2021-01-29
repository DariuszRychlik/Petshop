package com.dariuszrychlik.petshop.api.mapper;

import com.dariuszrychlik.petshop.api.model.CarDTO;
import com.dariuszrychlik.petshop.domain.Car;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CarMapper {

    CarMapper INSTANCE = Mappers.getMapper(CarMapper.class);

    CarDTO carToCarDTO(Car car);

    Car carDTOToCar(CarDTO carDTO);
}
