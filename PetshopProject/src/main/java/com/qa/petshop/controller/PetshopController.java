package com.qa.petshop.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qa.petshop.model.Animal;
import com.qa.petshop.services.AnimalService;

@RestController 
@CrossOrigin
public class PetshopController {

    @Autowired
    private AnimalService service;
    
    public PetshopController(AnimalService service) {
		super();
		this.service = service;
	}

    @GetMapping("/greeting")
    public String greeting() {
        return "Welcome to Scotts Petshop!";
    }
    
    @PostMapping("/create")
	public ResponseEntity<Animal> createAnimal(@RequestBody Animal animal) {
		return new ResponseEntity<Animal>(this.service.createAnimal(animal), HttpStatus.CREATED);
	}

	@GetMapping("/get")
	public ResponseEntity<List<Animal>> getAnimal() {
		return ResponseEntity.ok(this.service.getAnimal());
	}

	@PutMapping("/update")
	public ResponseEntity<Animal> updateAnimal(@RequestBody Animal animal, @PathParam("id") Long id) {
		return new ResponseEntity<Animal>(this.service.updateAnimal(animal, id), HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/remove/{id}")
	public ResponseEntity<Object> deleteAnimal(@PathVariable Long id) {
		if (this.service.deleteAnimal(id)) {
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}

//    @GetMapping(value = "/getAnimalAll")
//    public List<Animal> findAll(){
//        return petshopRepo.findAll();
//    }
//
//   @GetMapping(value = "/getAnimal/{id}")
//    public List<Animal> getAnimal(@PathVariable Long id) {
//        return petshopRepo.findAll();  	
//   }
//
//    @PostMapping(value = "/createAnimal")
//    public Animal save(@Valid @NotNull @RequestBody Animal animal){
//        return petshopRepo.save(animal);
//    }
//
//    @PutMapping(value = "/updateAnimal")
//    public Animal update(@Valid @NotNull @RequestBody Animal animal){
//        return petshopRepo.save(animal);
//    }
//
//    @DeleteMapping(value = "/deleteAnimal/{id}")
//    public void delete(@PathVariable Long id){
//        petshopRepo.deleteById(id);
//    }
//}