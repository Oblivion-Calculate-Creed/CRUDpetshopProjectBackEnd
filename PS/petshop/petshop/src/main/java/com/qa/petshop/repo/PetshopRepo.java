package com.company;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.duck.persistence.domain.Duck;

@Repository
public interface PetshopRepo extends JpaRepository<animal, Long> {

	List<Duck> findByColour(String colour);
}
