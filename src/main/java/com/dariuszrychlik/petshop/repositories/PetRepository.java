package com.dariuszrychlik.petshop.repositories;

import com.dariuszrychlik.petshop.domain.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PetRepository extends JpaRepository<Pet, Long> {

    List<Pet> getByStatus(String status);
}
