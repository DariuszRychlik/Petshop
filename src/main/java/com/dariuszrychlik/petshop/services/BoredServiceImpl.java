package com.dariuszrychlik.petshop.services;

import com.dariuszrychlik.petshop.api.mapper.BoredMapper;
import com.dariuszrychlik.petshop.api.model.BoredDTO;
import com.dariuszrychlik.petshop.domain.Bored;
import com.dariuszrychlik.petshop.repositories.BoredRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BoredServiceImpl implements BoredService {

    BoredRepository boredRepository;
    BoredMapper boredMapper;

    public BoredServiceImpl(BoredRepository boredRepository, BoredMapper boredMapper) {
        this.boredRepository = boredRepository;
        this.boredMapper = boredMapper;
    }

    @Override
    public List<BoredDTO> getAllBoreds() {
        return boredRepository.findAll()
                .stream()
                .map(boredMapper::boredToBoredDTO)
                .collect(Collectors.toList());
    }

    @Override
    public BoredDTO getBoredById(Long id) {
        return boredMapper.boredToBoredDTO(boredRepository.findById(id).get()); }

    @Override
    public List<BoredDTO> getBoredByStatus(String status) {
        return boredRepository.getByStatus(status)
                .stream()
                .map(boredMapper::boredToBoredDTO)
                .collect(Collectors.toList());
    }

    @Override
    public BoredDTO createNewBored(BoredDTO boredDTO) {

        Bored bored = boredMapper.boredDTOToBored(boredDTO);
        Bored savedBored = boredRepository.save(bored);


        return boredMapper.boredToBoredDTO(savedBored);
    }

    @Override
    public BoredDTO updateBored(Long id, BoredDTO boredDTO) {

        Bored bored = boredMapper.boredDTOToBored(boredDTO);
        bored.setId(id);

        Bored savedBored = boredRepository.save(bored);

        return boredMapper.boredToBoredDTO(savedBored);
    }

    @Override
    public void deleteBoredById(Long id) { boredRepository.deleteById(id);}
}
