package com.qa.petshop.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.petshop.model.Animal;

@Repository
public interface PetshopRepo extends JpaRepository<Animal, Long> {

}
