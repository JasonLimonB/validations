package com.validations.controller;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import com.validations.dto.ValidationsDTO;
import com.validations.service.ValidationsService;

@ExtendWith(MockitoExtension.class)
class ControllerTest {
	
	@InjectMocks
	Controller controller;
	@Mock
	ValidationsService services;

	@Test
	public void testValidations() {			
		ValidationsDTO dto= new ValidationsDTO();
		assertEquals(HttpStatus.OK, controller.validations(dto).getStatusCode());
	}
	
	@Test
	public void testValidation_LoadActiontype() {
		assertEquals(HttpStatus.OK, controller.validation_LoadActiontype("").getStatusCode());
	}
	
	@Test
	public void testValidation_LoadCreateDOW() {
		assertEquals(HttpStatus.OK, controller.validation_LoadCreateDOW(1).getStatusCode());
	}
	
	@Test
	public void testValidation_DestinationOrganizationCountryCode() {
		assertEquals(HttpStatus.OK, controller.validation_DestinationOrganizationCountryCode("").getStatusCode());
	}

	@Test
	public void testValidation_DestinationOrganizationNumber() {
		assertEquals(HttpStatus.OK, controller.validation_DestinationOrganizationNumber("").getStatusCode());
	}
	
	@Test
	public void testValidation_DestinationSortType() {
		assertEquals(HttpStatus.OK, controller.validation_DestinationSortType("").getStatusCode());
	}
	
	@Test
	public void testValidation_ServiceTypeCodeMnemonicText() {
		assertEquals(HttpStatus.OK, controller.validation_ServiceTypeCodeMnemonicText("").getStatusCode());
	}
	
	@Test
	public void testValidation_LoadPieceQuantity() {
		assertEquals(HttpStatus.OK, controller.validation_LoadPieceQuantity(1).getStatusCode());
	}
	
	@Test
	public void testValidation_LoadLatestPossibleArrivalTime() {
		assertEquals(HttpStatus.OK, controller.validation_LoadLatestPossibleArrivalTime("").getStatusCode());
	}
	
	@Test
	public void testValidation_LoadLatestArrivalDayOfWeek() {
		assertEquals(HttpStatus.OK, controller.validation_LoadLatestArrivalDayOfWeek(1).getStatusCode());
	}
	
	@Test
	public void testValidation_UnloadLoadDestinationCountryCode() {
		assertEquals(HttpStatus.OK, controller.validation_UnloadLoadDestinationCountryCode("").getStatusCode());
	}
	
	@Test
	public void testValidation_RecordEffectiveEndDate() {
		assertEquals(HttpStatus.OK, controller.validation_RecordEffectiveEndDate("").getStatusCode());
	}
}
