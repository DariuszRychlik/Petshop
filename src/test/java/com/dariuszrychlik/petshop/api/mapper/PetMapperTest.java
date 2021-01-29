package com.dariuszrychlik.petshop.api.mapper;

import com.dariuszrychlik.petshop.api.model.PetDTO;
import com.dariuszrychlik.petshop.domain.Pet;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PetMapperTest {

    PetMapper petMapper = PetMapper.INSTANCE;

    @Test
    void perToPetDTO() {
        //given
        Pet pet = new Pet();
        pet.setId(1L);
        pet.setName("Pet");
        pet.setStatus("available");

        //when
        PetDTO petDTO = petMapper.petToPetDTO(pet);


        //then
        assertEquals(Long.valueOf(1L), petDTO.getId());
        assertEquals("Pet", petDTO.getName());
        assertEquals("available", petDTO.getStatus());

    }
}