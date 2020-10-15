package com.qa.petshop.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.petshop.model.Animal;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@Sql(scripts = { "classpath:animal-schema.sql",
		"classpath:animal-data.sql" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles(profiles = "test")
public class PetsshopIntegrationTest {

	@Autowired
	private MockMvc mockMVC;

	@Autowired
	private ObjectMapper mapper;

	@Test
	void testCreate() throws Exception {
		Animal newAnimal = new Animal("Fluffy", "German Shepherd", "Dog", 500, "Male", "Brown", "01/12/12");
		String requestBody = this.mapper.writeValueAsString(newAnimal);
		RequestBuilder request = post("/create").contentType(MediaType.APPLICATION_JSON).content(requestBody);

		ResultMatcher checkStatus = status().is(201);

		Animal savedAnimal = new Animal("Fluffy", "German Shepherd", "Dog", 500, "Male", "Brown", "01/12/12");
		savedAnimal.setId(2L); 

		String resultBody = this.mapper.writeValueAsString(savedAnimal);
		ResultMatcher checkBody = content().json(resultBody);

		this.mockMVC.perform(request).andExpect(checkStatus).andExpect(checkBody);

		MvcResult result = this.mockMVC.perform(request).andExpect(checkStatus).andReturn();

		String reqBody = result.getResponse().getContentAsString();

		Animal animalResult = this.mapper.readValue(reqBody, Animal.class);
	}

	@Test
	void testUpdate() throws Exception {
		Animal newAnimal = new Animal("Fluffy", "German Shepherd", "Dog", 500, "Male", "Brown", "01/12/12");
		String requestBody = this.mapper.writeValueAsString(newAnimal);
		RequestBuilder request = put("/update?id=1").contentType(MediaType.APPLICATION_JSON).content(requestBody);

		ResultMatcher checkStatus = status().isAccepted();

		Animal savedAnimal = new Animal("Fluffy", "German Shepherd", "Dog", 500, "Male", "Brown", "01/12/12");
		savedAnimal.setId(1L);

		String resultBody = this.mapper.writeValueAsString(savedAnimal);
		ResultMatcher checkBody = content().json(resultBody);

		this.mockMVC.perform(request).andExpect(checkStatus).andExpect(checkBody);
	}

	@Test
	void testDelete() throws Exception {
		RequestBuilder request = delete("/remove/1");

		ResultMatcher checkStatus = status().is(200);

		this.mockMVC.perform(request).andExpect(checkStatus);
	}

	@Test
	void testRead() throws Exception {
		Animal animal = new Animal("Fluffy", "German Shepherd", "Dog", 500, "Male", "Brown", "01/12/12");
		animal.setId(1L); 
		List<Animal> animals = new ArrayList<>();
		animals.add(animal);
		String responseBody = this.mapper.writeValueAsString(animals);

		this.mockMVC.perform(get("/get")).andExpect(status().isOk()).andExpect(content().json(responseBody));
	}

}
