package com.dariuszrychlik.petshop.bootstrap;

import com.dariuszrychlik.petshop.domain.Jokes;
import com.dariuszrychlik.petshop.repositories.JokesRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DBDataLoaderJokes implements CommandLineRunner {

    JokesRepository jokesRepository;

    public DBDataLoaderJokes(JokesRepository jokesRepository) { this.jokesRepository = jokesRepository; }

    @Override
    public void run(String... args) throws Exception {

        Jokes programmer = new Jokes();
        programmer.setJoke("Programmer");
        programmer.setStatus("available");

        Jokes police = new Jokes();
        police.setJoke("Police");
        police.setStatus("available");

        Jokes blondHair = new Jokes();
        blondHair.setJoke("Blond Hair");
        blondHair.setStatus("available");

        Jokes jas = new Jokes();
        jas.setJoke("Jaś");
        jas.setStatus("available");

        Jokes mothetInLaw = new Jokes();
        mothetInLaw.setJoke("Teścowa");
        mothetInLaw.setStatus("available");

        jokesRepository.save(programmer);
        jokesRepository.save(police);
        jokesRepository.save(blondHair);
        jokesRepository.save(jas);
        jokesRepository.save(mothetInLaw);

        System.out.println("Data Jokes loaded to DB!");

    }
}
