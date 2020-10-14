package com.company.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.company.model.animal;

@Repository
public interface PetshopRepo extends JpaRepository<Animal, Long> {

}
