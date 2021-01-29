package com.dariuszrychlik.petshop.repositories;

import com.dariuszrychlik.petshop.domain.Jokes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JokesRepository extends JpaRepository<Jokes, Long> {

    List<Jokes> getByStatus(String status);
}
