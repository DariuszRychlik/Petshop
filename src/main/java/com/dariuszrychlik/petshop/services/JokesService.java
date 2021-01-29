package com.dariuszrychlik.petshop.services;

import com.dariuszrychlik.petshop.api.model.JokesDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface JokesService {

    List<JokesDTO> getAllJokes();

    JokesDTO getJokesById(Long id);

    List<JokesDTO> getJokesByStatus(String status);

    JokesDTO createNewJokes(JokesDTO jokesDTO);

    JokesDTO updateJokes(Long id, JokesDTO jokesDTO);

    void deleteJokesById(Long id);

}
