package com.dariuszrychlik.petshop.services;

import com.dariuszrychlik.petshop.api.model.PetDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PetService {

    List<PetDTO> getAllPets();

    PetDTO getPetById(Long id);

    List<PetDTO> getPetByStatus(String status);

    PetDTO createNewPet(PetDTO petDTO);

    PetDTO updatePet(Long id, PetDTO petDTO);

    void deletePetById(Long id);


}
