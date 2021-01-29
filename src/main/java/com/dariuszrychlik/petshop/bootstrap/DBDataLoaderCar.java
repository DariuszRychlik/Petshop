package com.dariuszrychlik.petshop.bootstrap;

import com.dariuszrychlik.petshop.domain.Car;
import com.dariuszrychlik.petshop.repositories.CarRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DBDataLoaderCar implements CommandLineRunner {

    CarRepository carRepository;

    public DBDataLoaderCar(CarRepository carRepository) { this.carRepository = carRepository; }

    @Override
    public void run(String... args) throws Exception {

        Car toyota = new Car();
        toyota.setName("Toyota");
        toyota.setStatus("available");

        Car gmc = new Car();
        gmc.setName("GMC");
        gmc.setStatus("available");

        Car mercedes = new Car();
        mercedes.setName("Mercedes");
        mercedes.setStatus("available");

        Car mitsubishi = new Car();
        mitsubishi.setName("Mitsubishi");
        mitsubishi.setStatus("available");

        Car fiat = new Car();
        fiat.setName("Fiat");
        fiat.setStatus("available");

        carRepository.save(toyota);
        carRepository.save(gmc);
        carRepository.save(mercedes);
        carRepository.save(mitsubishi);
        carRepository.save(fiat);

        System.out.println("Data Car loaded to DB!");
    }
}
