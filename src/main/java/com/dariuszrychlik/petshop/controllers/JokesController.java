package com.dariuszrychlik.petshop.controllers;

import com.dariuszrychlik.petshop.api.model.JokesDTO;
import com.dariuszrychlik.petshop.api.model.JokesListDTO;
import com.dariuszrychlik.petshop.api.model.PetDTO;
import com.dariuszrychlik.petshop.api.model.PetListDTO;
import com.dariuszrychlik.petshop.services.JokesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/jokes/")
public class JokesController {

    private final JokesService jokesService;

    public JokesController(JokesService jokesService) {this.jokesService = jokesService; }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public JokesDTO getJokesById(@PathVariable Long id) {
        return jokesService.getJokesById(id);
    }

    @GetMapping("findByStatus/{status}")
    public ResponseEntity<JokesListDTO> getJokesByStatus(@PathVariable String status) {
        return new ResponseEntity<JokesListDTO>(
                new JokesListDTO(jokesService.getJokesByStatus(status)), HttpStatus.OK);

    }

    @PostMapping
    public ResponseEntity<JokesDTO> createNewJokes(@RequestBody JokesDTO jokesDTO) {
        return new ResponseEntity<JokesDTO>(jokesService.createNewJokes(jokesDTO), HttpStatus.CREATED);

    }

    @PutMapping("{id}")
    public ResponseEntity<JokesDTO> updateJokes(@PathVariable Long id, @RequestBody JokesDTO jokesDTO) {
        return new ResponseEntity<JokesDTO>(jokesService.updateJokes(id, jokesDTO), HttpStatus.OK);

    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteJokes(@PathVariable Long id) {

        jokesService.deleteJokesById(id);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
