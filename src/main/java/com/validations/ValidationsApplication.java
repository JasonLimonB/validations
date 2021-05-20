package com.validations;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.validations.service.ValidationsService;

@SpringBootApplication
public class ValidationsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ValidationsApplication.class, args);
		
		ValidationsService services = new ValidationsService();
		boolean result = services.validation_LoadActiontype();
		System.out.println(result);
	}

}
