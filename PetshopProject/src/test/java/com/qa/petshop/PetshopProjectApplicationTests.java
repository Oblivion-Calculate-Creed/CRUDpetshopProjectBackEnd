package com.qa.petshop;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.qa.petshop.model.Animal;

import nl.jqno.equalsverifier.EqualsVerifier;

@SpringBootTest
class PetshopProjectApplicationTests {

	@Test //smoke test
	void contextLoads() {
	}

//	@Test
//	void giveCoverage() {
//		EqualsVerifier.forClass(Animal.class).usingGetClass().verify();
//	}

}