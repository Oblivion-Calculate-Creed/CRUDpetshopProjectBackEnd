package com.company;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
@EnableSwagger2
public class PetshopSpring extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run (PetshopSpring.class, args);
	}

}
