package com.dariuszrychlik.petshop.repositories;

import com.dariuszrychlik.petshop.domain.Bored;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoredRepository extends JpaRepository<Bored, Long> {

    List<Bored> getByStatus(String status);
}
