package com.qa.petshop.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import com.qa.petshop.model.Animal;
import com.qa.petshop.repo.PetshopRepo;
import com.qa.petshop.services.AnimalService;

@SpringBootTest
@ActiveProfiles(profiles = "test")
public class PetshopServiceUnitTest {

	@Autowired
	private AnimalService service;

	@MockBean
	private PetshopRepo repo;

	@Test
	void testCreate() {

		Long id = 1L;
		Animal newAnimal = new Animal("Spikey", "Border Collie", "Dog", 250, "Female", "Black", "11/06/12");
		Animal savedAnimal = new Animal("Spikey", "Border Collie", "Dog", 250, "Female", "Black", "11/06/12");
		savedAnimal.setId(id);

		Mockito.when(this.repo.save(newAnimal)).thenReturn(savedAnimal);

		assertThat(this.service.createAnimal(newAnimal)).isEqualTo(savedAnimal);

		Mockito.verify(this.repo, Mockito.times(1)).save(newAnimal);
	}

	@Test
	void testUpdate() {

		Long id = 1L;

		Animal newAnimal = new Animal("Spikey", "Border Collie", "Dog", 250, "Female", "Black", "11/06/12");

		Animal oldAnimal = new Animal("Dan", "Siamese", "Cat", 50, "Male", "White", "30/07/10");
		oldAnimal.setId(id);

		Animal updatedAnimal = new Animal("Spikey", "Border Collie", "Dog", 250, "Female", "Black", "11/06/12");
		updatedAnimal.setId(id);

		Mockito.when(this.repo.findById(id)).thenReturn(Optional.of(oldAnimal));
		Mockito.when(this.repo.save(updatedAnimal)).thenReturn(updatedAnimal);

		assertThat(this.service.updateAnimal(newAnimal, id)).isEqualTo(updatedAnimal);

		Mockito.verify(this.repo, Mockito.times(1)).findById(id);
		Mockito.verify(this.repo, Mockito.times(1)).save(updatedAnimal);
	}

	@Test
	void testGet() {

		Animal animal = new Animal("Blaze", "Bearded Dragon", "Lizard", 80, "Male", "Green", "18/06/19");
		animal.setId(1L); 
		List<Animal> animals = new ArrayList<>();
		animals.add(animal);

		Mockito.when(this.repo.findAll()).thenReturn(animals);

		assertThat(this.service.getAnimal()).isEqualTo(animals);

		Mockito.verify(this.repo, Mockito.times(1)).findAll();
	}

	@Test
	void testDelete() {

		Long id = 1L;
		boolean found = false;

		Mockito.when(this.repo.existsById(id)).thenReturn(found);

		assertThat(this.service.deleteAnimal(id)).isEqualTo(!found);

		Mockito.verify(this.repo, Mockito.times(1)).existsById(id);
	}
}
