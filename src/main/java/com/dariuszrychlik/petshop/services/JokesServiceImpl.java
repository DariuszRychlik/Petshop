package com.dariuszrychlik.petshop.services;

import com.dariuszrychlik.petshop.api.mapper.JokesMapper;
import com.dariuszrychlik.petshop.api.model.JokesDTO;
import com.dariuszrychlik.petshop.domain.Jokes;
import com.dariuszrychlik.petshop.repositories.JokesRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class JokesServiceImpl implements JokesService {

    JokesRepository jokesRepository;
    JokesMapper jokesMapper;

    public JokesServiceImpl(JokesRepository jokesRepository, JokesMapper jokesMapper) {
        this.jokesRepository = jokesRepository;
        this.jokesMapper = jokesMapper;
    }

    @Override
    public List<JokesDTO> getAllJokes() {
        return jokesRepository.findAll()
                .stream()
                .map(jokesMapper::jokesToJokesDTO)
                .collect(Collectors.toList());
    }

    @Override
    public JokesDTO getJokesById(Long id) {
        return jokesMapper.jokesToJokesDTO(jokesRepository.findById(id).get()); }

    @Override
    public List<JokesDTO> getJokesByStatus(String status) {
        return jokesRepository.getByStatus(status)
                .stream()
                .map(jokesMapper::jokesToJokesDTO)
                .collect(Collectors.toList());
    }

    @Override
    public JokesDTO createNewJokes(JokesDTO jokesDTO) {

        Jokes jokes = jokesMapper.jokesDTOToJokes(jokesDTO);
        Jokes savedJokes = jokesRepository.save(jokes);

        return jokesMapper.jokesToJokesDTO(savedJokes);
    }

    @Override
    public JokesDTO updateJokes(Long id, JokesDTO jokesDTO) {

        Jokes jokes = jokesMapper.jokesDTOToJokes(jokesDTO);
        jokes.setId(id);

        Jokes savedJokes = jokesRepository.save(jokes);

        return jokesMapper.jokesToJokesDTO(savedJokes);
    }

    @Override
    public void deleteJokesById(Long id) { jokesRepository.deleteById(id);}
}
