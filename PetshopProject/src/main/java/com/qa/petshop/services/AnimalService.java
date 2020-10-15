package com.qa.petshop.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.qa.wood.exceptions.WoodNotFoundException;
import com.qa.wood.persistence.domain.Wood;
import com.qa.wood.persistence.repos.WoodRepo;

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
		// If doesn't find a matching Wood, throw exception
		Optional<Animal> optAnimal = this.repo.findById(id);
		Animal oldAnimal = optAnimal.orElseThrow(() -> new AnimalNotFoundException());

		oldAnimal.setAge(animal.getAge());
		oldAnimal.setArtificial(animal.isArtificial());
		oldAnimal.setColour(animal.getColour());
		oldAnimal.setConiferous(animal.isConiferous());
		oldAnimal.setName(animal.getName());
		oldAnimal.setSoft(animal.isSoft());
		oldAnimal.setWeight(animal.getWeight());

		Animal saved = this.repo.save(oldAnimal);
		return saved;
	}

	public boolean deleteAnimal(Long id) {
		this.repo.deleteById(id);
		return !this.repo.existsById(id);
	}
}
