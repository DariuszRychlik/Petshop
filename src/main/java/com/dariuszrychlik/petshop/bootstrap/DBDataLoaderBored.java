package com.dariuszrychlik.petshop.bootstrap;

import com.dariuszrychlik.petshop.domain.Bored;
import com.dariuszrychlik.petshop.repositories.BoredRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DBDataLoaderBored implements CommandLineRunner {

    BoredRepository boredRepository;

    public DBDataLoaderBored(BoredRepository boredRepository) { this.boredRepository = boredRepository; }

    @Override
    public void run(String... args) throws Exception {

        Bored work = new Bored();
        work.setActivity("Work hard");
        work.setStatus("work");

        Bored study = new Bored();
        study.setActivity("Study hard");
        study.setStatus("work");

        Bored drink = new Bored();
        drink.setActivity("Drink hard");
        drink.setStatus("work");

        Bored eat = new Bored();
        eat.setActivity("Eat hard");
        eat.setStatus("work");

        Bored sport = new Bored();
        sport.setActivity("Sport hard");
        sport.setStatus("work");



        boredRepository.save(work);
        boredRepository.save(study);
        boredRepository.save(drink);
        boredRepository.save(eat);
        boredRepository.save(sport);

        System.out.println("Data Bored loaded to DB");
    }
}
