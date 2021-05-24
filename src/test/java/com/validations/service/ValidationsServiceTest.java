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
	public void testValidation_LoadActiontypeADD() {
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
	public void testValidation_LoadActiontypeNull() {
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
	
	@Test
	public void testValidation_LoadCreateDOWCatch() {		
		assertFalse(services.validation_LoadCreateDOW(null).isResult());
	}
	
	@Test
	public void testValidation_DestinationOrganizationCountryCode() {		
		assertTrue(services.validation_DestinationOrganizationCountryCode("MX").isResult());
	}
	
	@Test
	public void testValidation_DestinationOrganizationCountryCodeElse() {		
		assertFalse(services.validation_DestinationOrganizationCountryCode("M").isResult());
	}
	
	@Test
	public void testValidation_DestinationOrganizationCountryCodeNull() {		
		assertFalse(services.validation_DestinationOrganizationCountryCode(null).isResult());
	}
	
	@Test
	public void testValidation_DestinationOrganizationNumber() {		
		assertEquals("success",services.validation_DestinationOrganizationNumber("1q234").getMessage());
	}
	
	@Test
	public void testValidation_DestinationOrganizationNumberElse() {		
		assertFalse(services.validation_DestinationOrganizationNumber("1q2345").isResult());
	}
	
	@Test
	public void testValidation_DestinationOrganizationNumberNull() {		
		assertFalse(services.validation_DestinationOrganizationNumber(null).isResult());
	}
	
	@Test
	public void testValidation_DestinationSortType() {		
		assertEquals("success",services.validation_DestinationSortType("A").getMessage());
	}
	
	@Test
	public void testValidation_DestinationSortTypeElse() {		
		assertEquals("Invalid DestinationSortType",services.validation_DestinationSortType("B").getMessage());
	}
	
	@Test 
	public void testValidation_DestinationSortTypeNull() {		
		assertFalse(services.validation_DestinationSortType(null).isResult());
	}
	
	@Test
	public void testValidation_ServiceTypeCodeMnemonicText() {		
		assertEquals("success",services.validation_ServiceTypeCodeMnemonicText("1DA").getMessage());
	}
	
	@Test
	public void testValidation_ServiceTypeCodeMnemonicTextElse() {		
		assertFalse(services.validation_ServiceTypeCodeMnemonicText("1AA").isResult());
	}
	
	@Test
	public void testValidation_ServiceTypeCodeMnemonicTextNull() {		
		assertFalse(services.validation_ServiceTypeCodeMnemonicText(null).isResult());
	}
	
	@Test
	public void testvalidation_LoadPieceQuantity() {		
		assertEquals("success",services.validation_LoadPieceQuantity(1234).getMessage());
	}
	
	@Test
	public void testvalidation_LoadPieceQuantityElse() {		
		assertEquals("Invalid LoadPieceQuantity",services.validation_LoadPieceQuantity(12347).getMessage());
	}
	
	@Test
	public void testvalidation_LoadPieceQuantityCatch() {		
		assertFalse(services.validation_LoadPieceQuantity(null).isResult());
	}
	
	@Test
	public void testValidation_LoadLatestPossibleArrivalTime() {		
		assertTrue(services.validation_LoadLatestPossibleArrivalTime("19:30").isResult());
	}
	
	@Test
	public void testValidation_LoadLatestPossibleArrivalTimeElse() {		
		assertFalse(services.validation_LoadLatestPossibleArrivalTime("19:30:00").isResult());
	}
	
	@Test
	public void testValidation_LoadLatestArrivalDayOfWeek() {		
		assertTrue(services.validation_LoadLatestArrivalDayOfWeek(1).isResult());
	}
	
	@Test
	public void testValidation_LoadLatestArrivalDayOfWeekElse() {		
		assertFalse(services.validation_LoadLatestArrivalDayOfWeek(8).isResult());
	}
	
	@Test
	public void testValidation_UnloadLoadDestinationCountryCode() {		
		assertTrue(services.validation_UnloadLoadDestinationCountryCode("MX").isResult());
	}
	
	@Test
	public void testValidation_UnloadLoadDestinationCountryCodeElse() {		
		assertFalse(services.validation_UnloadLoadDestinationCountryCode("M").isResult());
	}
	
	@Test
	public void testValidation_RecordEffectiveEndDate() {		
		assertTrue(services.validation_RecordEffectiveEndDate("2021-04-30").isResult());
	}
	
	@Test
	public void testValidation_RecordEffectiveEndDateElse() {		
		assertFalse(services.validation_RecordEffectiveEndDate("20-04-30").isResult());
	}
	
	@Test
	public void testValidation_RecordEffectiveEndDateNull() {		
		assertFalse(services.validation_RecordEffectiveEndDate(null).isResult());
	}

	@Test
	public void testIsValidLoadNumberIDNull(){
		assertFalse(services.isValidLoadNumberID(null));
	}
	@Test
	public void testIsValidLoadNumberIDStringValid(){
		assertTrue(services.isValidLoadNumberID("1234567890"));
	}
	@Test
	public void testIsValidLoadNumberIDStringInvalid(){
		assertFalse(services.isValidLoadNumberID("1"));
	}
	@Test
	public void testIsValidLoadNumberIDEmptyString(){
		assertFalse(services.isValidLoadNumberID(""));
	}

	@Test
	public void testIsValidRecordEffectiveStartDateNull(){
		assertFalse(services.isValidRecordEffectiveStartDate(null));
	}
	@Test
	public void testIsValidRecordEffectiveStartDateBadFormat(){
		assertFalse(services.isValidRecordEffectiveStartDate("12/12/2021"));
	}
	@Test
	public void testIsValidRecordEffectiveStartDateEmptyString(){
		assertFalse(services.isValidRecordEffectiveStartDate(""));
	}
	@Test
	public void testIsValidRecordEffectiveStartDateCorrectFormat(){
		assertTrue(services.isValidRecordEffectiveStartDate("2021/12/12"));
	}

	@Test
	public void testIsValidOriginOrganizationCountryCodeCorrectLength(){
		assertTrue(services.isValidOriginOrganizationCountryCode("12"));
	}
	@Test
	public void testIsValidOriginOrganizationCountryCodeBadLength(){
		assertFalse(services.isValidOriginOrganizationCountryCode("12345"));
	}
	@Test
	public void testIsValidOriginOrganizationCountryCodeNull(){
		assertFalse(services.isValidOriginOrganizationCountryCode(null));
	}
	@Test
	public void testIsValidOriginOrganizationCountryCodeEmptyString(){
		assertFalse(services.isValidOriginOrganizationCountryCode(""));
	}

	@Test
	public void testIsValidOriginOrganizationNumberNull(){
		assertFalse(services.isValidOriginOrganizationNumber(null));
	}
	@Test
	public void testIsValidOriginOrganizationNumberCorrectLength(){
		assertTrue(services.isValidOriginOrganizationNumber("123"));
	}
	@Test
	public void testIsValidOriginOrganizationNumberBadLength(){
		assertFalse(services.isValidOriginOrganizationNumber("1234567890"));
	}
	@Test
	public void testIsValidOriginOrganizationNumberEmptyString(){
		assertFalse(services.isValidOriginOrganizationNumber(""));
	}

	@Test
	public void testIsValidRiginSortTypeCorrectParam(){
		assertTrue(services.isValidRiginSortType("A"));
	}
	@Test
	public void testIsValidRiginSortTypeIncorrectParam(){
		assertFalse(services.isValidRiginSortType("ASDF"));
	}
	@Test
	public void testIsValidRiginSortTypeNull(){
		assertFalse(services.isValidRiginSortType(null));
	}

	@Test
	public void testIsValidLoadRouteCodeCorrectParam(){
		assertTrue(services.isValidLoadRouteCode("A1"));
	}
	@Test
	public void testIsValidLoadRouteCodeIncorrectParam(){
		assertFalse(services.isValidLoadRouteCode("A1B1ss"));
	}
	@Test
	public void testIsValidLoadRouteCodeNull(){
		assertFalse(services.isValidLoadRouteCode(null));
	}

	@Test
	public void testIsValidEquipmentTrailerTypeCodeCorrectParam(){
		assertTrue(services.isValidEquipmentTrailerTypeCode("A2"));
	}
	@Test
	public void testIsValidEquipmentTrailerTypeCodeIncorrectParam(){
		assertFalse(services.isValidEquipmentTrailerTypeCode("#$"));
	}
	@Test
	public void testIsValidEquipmentTrailerTypeCodeNull(){
		assertFalse(services.isValidEquipmentTrailerTypeCode(null));
	}
	@Test
	public void testIsValidEquipmentTrailerTypeCodeBadLength(){
		assertFalse(services.isValidEquipmentTrailerTypeCode("A23SR4233"));
	}

	@Test
	public void testIsValidLoadVolumeUtilizationPercentNull(){
		assertFalse(services.isValidLoadVolumeUtilizationPercent(null));
	}
	@Test
	public void testIsValidLoadVolumeUtilizationPercentGoodParam(){
		assertTrue(services.isValidLoadVolumeUtilizationPercent(123));
	}
	@Test
	public void testIsValidLoadVolumeUtilizationPercentIncorrectLengthParam(){
		assertFalse(services.isValidLoadVolumeUtilizationPercent(123456));
	}

	@Test
	public void testIsValidLoadEarliestPossibleDepartureTimestampBadFormat(){
		assertFalse(services.isValidLoadEarliestPossibleDepartureTimestamp("13/22"));
	}
	@Test
	public void testIsValidLoadEarliestPossibleDepartureTimestampCorrectFormat(){
		assertTrue(services.isValidLoadEarliestPossibleDepartureTimestamp("13:22"));
	}
	@Test
	public void testIsValidLoadEarliestPossibleDepartureTimestampEmpty(){
		assertFalse(services.isValidLoadEarliestPossibleDepartureTimestamp(""));
	}

	@Test
	public void testIsValidLoadEarliestDepartureDayOfWeekCorrectParam(){
		assertTrue(services.isValidLoadEarliestDepartureDayOfWeek(5));
	}
	@Test
	public void testIsValidLoadEarliestDepartureDayOfWeekIncorrectParam(){
		assertFalse(services.isValidLoadEarliestDepartureDayOfWeek(10));
	}


	@Test
	public void testIsValidUnloadLoadDestinationOrganizationNumberCorrectParam(){
		assertTrue(services.isValidUnloadLoadDestinationOrganizationNumber("AQW12"));
	}
	@Test
	public void testIsValidUnloadLoadDestinationOrganizationNumberIncorrectParam(){
		assertFalse(services.isValidUnloadLoadDestinationOrganizationNumber("$#%$"));
	}
	@Test
	public void testIsValidUnloadLoadDestinationOrganizationNumberEmpty(){
		assertFalse(services.isValidUnloadLoadDestinationOrganizationNumber(""));
	}


	@Test
	public void testIsValidUnloadLoadDestinationSortTypeCorrectParam(){
		assertTrue(services.isValidUnloadLoadDestinationSortType("S"));
	}
	@Test
	public void testIsValidUnloadLoadDestinationSortTypeIncorrectParam(){
		assertFalse(services.isValidUnloadLoadDestinationSortType("Z"));
	}


}
