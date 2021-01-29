package com.dariuszrychlik.petshop.api.mapper;

import com.dariuszrychlik.petshop.api.model.BoredDTO;
import com.dariuszrychlik.petshop.domain.Bored;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BoredMapper {

    BoredMapper INSTANCE = Mappers.getMapper(BoredMapper.class);

    BoredDTO boredToBoredDTO(Bored bored);

    Bored boredDTOToBored(BoredDTO boredDTO);

}
