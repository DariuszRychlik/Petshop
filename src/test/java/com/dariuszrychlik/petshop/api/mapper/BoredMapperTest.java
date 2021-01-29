package com.dariuszrychlik.petshop.api.mapper;

import com.dariuszrychlik.petshop.api.model.BoredDTO;
import com.dariuszrychlik.petshop.domain.Bored;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoredMapperTest {

    BoredMapper boredMapper = BoredMapper.INSTANCE;

    @Test
    void boredToBoredDTO() {
        //given
        Bored bored = new Bored();
        bored.setId(1L);
        bored.setActivity("Bored");
        bored.setStatus("work");
        //when
        BoredDTO boredDTO = boredMapper.boredToBoredDTO(bored);

        //then
        assertEquals(Long.valueOf(1L), boredDTO.getId());
        assertEquals("Bored", boredDTO.getActivity());
        assertEquals("work", boredDTO.getStatus());
    }
}