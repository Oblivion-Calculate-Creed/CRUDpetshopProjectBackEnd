package com.qa.petshop.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.qa.petshop.exceptions.AnimalNotFound;
import com.qa.petshop.model.Animal;
import com.qa.petshop.repo.PetshopRepo;

//@Component
@Service
public class AnimalService {

//	@Autowired
	private PetshopRepo repo;

	public AnimalService(PetshopRepo repo) {
		super();
		this.repo = repo;
	}

	public Animal createAnimal(Animal animal) {
		return this.repo.save(animal);
	}

	public List<Animal> getAnimal() {
		return this.repo.findAll();
	}

	public Animal updateAnimal(Animal animal, Long id) {
		
		Optional<Animal> optAnimal = this.repo.findById(id);
		Animal oldAnimal = optAnimal.orElseThrow(() -> new AnimalNotFound());

		oldAnimal.setGivenName(animal.getGivenName());
		oldAnimal.setCommonName(animal.getCommonName());
		oldAnimal.setType(animal.getType());
		oldAnimal.setPrice(animal.getPrice());
		oldAnimal.setSex(animal.getSex());
		oldAnimal.setColour(animal.getColour());
		oldAnimal.setArrival(animal.getArrival());

		Animal saved = this.repo.save(oldAnimal);
		return saved;
	}

	public boolean deleteAnimal(Long id) {
		this.repo.deleteById(id);
		return !this.repo.existsById(id);
	}
}
