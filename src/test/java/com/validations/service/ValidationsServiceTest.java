package com.validations.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import com.validations.dto.ValidationsDTO;


@ExtendWith(MockitoExtension.class)
class ValidationsServiceTest {

	@InjectMocks
	ValidationsService services;
	
	@Test
	public void testValidations() {
		ValidationsDTO dto = new ValidationsDTO();
		assertEquals("success", services.validations(dto).getMessage());
	}
	
	@Test
	public void testValidation_LoadActiontype() {
		assertTrue(services.validation_LoadActiontype("ADD").isResult());
	}
	
	@Test
	public void testValidation_LoadActiontypeUPDATE() {
		assertTrue(services.validation_LoadActiontype("UPDATE").isResult());
	}
	
	@Test
	public void testValidation_LoadActiontypeElse() {
		assertFalse(services.validation_LoadActiontype("H").isResult());
	}
	
	@Test
	public void testValidation_LoadActiontypenull() {
		assertFalse(services.validation_LoadActiontype(null).isResult());
	}

	@Test
	public void testValidation_LoadCreateDOW() {		
		assertTrue(services.validation_LoadCreateDOW(1).isResult());
	}
	
	@Test
	public void testValidation_LoadCreateDOWELSE() {		
		assertFalse(services.validation_LoadCreateDOW(0).isResult());
	}
	
	
}
