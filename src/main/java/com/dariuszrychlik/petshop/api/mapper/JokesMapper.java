package com.dariuszrychlik.petshop.api.mapper;

import com.dariuszrychlik.petshop.api.model.JokesDTO;
import com.dariuszrychlik.petshop.domain.Jokes;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface JokesMapper {

    JokesMapper INSTANCE = Mappers.getMapper(JokesMapper.class);

    JokesDTO jokesToJokesDTO(Jokes jokes);

    Jokes jokesDTOToJokes(JokesDTO jokesDTO);
}
