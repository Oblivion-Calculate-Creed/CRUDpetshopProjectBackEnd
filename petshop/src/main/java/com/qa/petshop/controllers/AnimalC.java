package com.company.controllers;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.Animal;
import com.company.PetshopRepo;

@RestController ]
@RequestMapping(value = "/petshop")
public class PetshopController {

    @Autowired
    private PetshopRepo petshopRepo;

    @GetMapping("/greeting")
    public String greeting() {
        return "Welcome to Scotts Petshop!";
    }

    @GetMapping(value = "/getAnimalAll")
    public List<Animal> findAll(){
        return todoRepo.findAll();
    }

    @GetMapping(value = "/getAnimal/{id}")
    public ResponseEntity<Animal> getAnimal(@PathVariable Long id) {
        return todoRepo.findAll();
    }

    @PostMapping(value = "/createAnimal")
    public Animal save(@Valid @NotNull @RequestBody Animal animal){
        return PetshopRepo.save(animal);
    }

    @PutMapping(value = "/updateAnimal")
    public Animal update(@Valid @NotNull @RequestBody Animal animal){
        return PetshopRepo.save(animal);
    }

    @DeleteMapping(value = "/deleteAnimal/{id}")
    public void delete(@PathVariable Long id){
        petshopRepo.deleteById(id);

        @DeleteMapping(value = "/deleteAnimalAll")
        public void deleteAll(){
            petshopRepo.deleteAll();
    }
}
