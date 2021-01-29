package com.dariuszrychlik.petshop.controllers;

import com.dariuszrychlik.petshop.api.model.BoredDTO;
import com.dariuszrychlik.petshop.api.model.BoredListDTO;
import com.dariuszrychlik.petshop.services.BoredService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/bored/")
public class BoredController {

    private final BoredService boredService;

    public BoredController(BoredService boredService) { this.boredService = boredService; }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public BoredDTO getBoredById(@PathVariable Long id) {
        return boredService.getBoredById(id);
    }

    @GetMapping("findByStatus/{status}")
    public ResponseEntity<BoredListDTO> getBoredByStatus(@PathVariable String status) {
        return new ResponseEntity<BoredListDTO>(
                new BoredListDTO(boredService.getBoredByStatus(status)), HttpStatus.OK);

    }

    @PostMapping
    public ResponseEntity<BoredDTO> createNewBored(@RequestBody BoredDTO boredDTO) {
        return new ResponseEntity<BoredDTO>(boredService.createNewBored(boredDTO), HttpStatus.CREATED);

    }

    @PutMapping("{id}")
    public ResponseEntity<BoredDTO> updateBored(@PathVariable Long id, @RequestBody BoredDTO boredDTO) {
        return new ResponseEntity<BoredDTO>(boredService.updateBored(id, boredDTO), HttpStatus.OK);

    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteBored(@PathVariable Long id) {

        boredService.deleteBoredById(id);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }

}
