package com.dariuszrychlik.petshop.api.mapper;

import com.dariuszrychlik.petshop.api.model.PetDTO;
import com.dariuszrychlik.petshop.domain.Pet;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PetMapper {

    PetMapper INSTANCE = Mappers.getMapper(PetMapper.class);

    PetDTO petToPetDTO(Pet pet);

    Pet petDTOToPet(PetDTO petDTO);
}
