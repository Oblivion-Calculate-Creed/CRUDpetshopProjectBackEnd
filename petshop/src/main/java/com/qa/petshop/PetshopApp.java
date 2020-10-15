package com.company.petshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
@EnableSwagger2
public class PetshopApp extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run (PetshopApp.class, args);
	}

}

