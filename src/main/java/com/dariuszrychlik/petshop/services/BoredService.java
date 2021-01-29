package com.dariuszrychlik.petshop.services;

import com.dariuszrychlik.petshop.api.model.BoredDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BoredService {

    List<BoredDTO> getAllBoreds();

    BoredDTO getBoredById(Long id);

    List<BoredDTO> getBoredByStatus(String status);

    BoredDTO createNewBored(BoredDTO boredDTO);

    BoredDTO updateBored(Long id, BoredDTO boredDTO);

    void deleteBoredById(Long id);
}
