package com.dariuszrychlik.petshop.controllers;


import com.dariuszrychlik.petshop.api.model.PetListDTO;
import com.dariuszrychlik.petshop.api.model.PetDTO;
import com.dariuszrychlik.petshop.services.PetService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pet/")
public class PetController {

    private final PetService petService;

    public PetController(PetService petService) {
        this.petService = petService;
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public PetDTO getPetById(@PathVariable Long id) {
        return petService.getPetById(id);
    }

    @GetMapping("findByStatus/{status}")
    public ResponseEntity<PetListDTO> getPetByStatus(@PathVariable String status) {
        return new ResponseEntity<PetListDTO>(
                new PetListDTO(petService.getPetByStatus(status)), HttpStatus.OK);

    }

    @PostMapping
    public ResponseEntity<PetDTO> createNewPet(@RequestBody PetDTO petDTO) {
        return new ResponseEntity<PetDTO>(petService.createNewPet(petDTO), HttpStatus.CREATED);

    }

    @PutMapping("{id}")
    public ResponseEntity<PetDTO> updatePet(@PathVariable Long id, @RequestBody PetDTO petDTO) {
        return new ResponseEntity<PetDTO>(petService.updatePet(id, petDTO), HttpStatus.OK);

    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deletePet(@PathVariable Long id) {

        petService.deletePetById(id);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }


}
