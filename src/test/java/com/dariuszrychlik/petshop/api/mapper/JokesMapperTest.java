package com.dariuszrychlik.petshop.api.mapper;

import com.dariuszrychlik.petshop.api.model.JokesDTO;
import com.dariuszrychlik.petshop.domain.Jokes;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JokesMapperTest {

    JokesMapper jokesMapper = JokesMapper.INSTANCE;

    @Test
    void jokesToJokesDTO() {
        //given
        Jokes jokes = new Jokes();
        jokes.setId(1L);
        jokes.setJoke("Jokes");
        jokes.setStatus("available");

        //when
        JokesDTO jokesDTO = jokesMapper.jokesToJokesDTO(jokes);

        //then
        assertEquals(Long.valueOf(1L), jokesDTO.getId());
        assertEquals("Jokes", jokesDTO.getJoke());
        assertEquals("available", jokesDTO.getStatus());
    }
}