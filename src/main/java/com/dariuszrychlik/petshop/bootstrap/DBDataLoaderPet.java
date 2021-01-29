package com.dariuszrychlik.petshop.bootstrap;

import com.dariuszrychlik.petshop.domain.Pet;
import com.dariuszrychlik.petshop.repositories.PetRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DBDataLoaderPet implements CommandLineRunner {

    PetRepository petRepository;

    public DBDataLoaderPet(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Pet dog = new Pet();
        dog.setName("Dog");
        dog.setStatus("available");

        Pet cat = new Pet();
        cat.setName("Cat");
        cat.setStatus("available");

        Pet parrot = new Pet();
        parrot.setName("Parrot");
        parrot.setStatus("available");

        Pet cow = new Pet();
        cow.setName("Cow");
        cow.setStatus("available");

        Pet horse = new Pet();
        horse.setName("Horse");
        horse.setStatus("available");

        petRepository.save(dog);
        petRepository.save(cat);
        petRepository.save(parrot);
        petRepository.save(cow);
        petRepository.save(horse);

        System.out.println("Data Pet loaded to DB!");
    }
}
