package com.qa.petshop.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.petshop.model.Animal;
import com.qa.petshop.repo.PetshopRepo;

@RestController 
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
        return petshopRepo.findAll();
    }

//   @GetMapping(value = "/getAnimal/{id}")
//    public ResponseEntity<Animal> getAnimal(@PathVariable Long id) {
//        return petshopRepo.findAll();  	
//   }

    @PostMapping(value = "/createAnimal")
    public Animal save(@Valid @NotNull @RequestBody Animal animal){
        return petshopRepo.save(animal);
    }

    @PutMapping(value = "/updateAnimal")
    public Animal update(@Valid @NotNull @RequestBody Animal animal){
        return petshopRepo.save(animal);
    }

    @DeleteMapping(value = "/deleteAnimal/{id}")
    public void delete(@PathVariable Long id){
        petshopRepo.deleteById(id);
    }
}