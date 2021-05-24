package com.validations.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.validations.dto.Response;
import com.validations.dto.ValidationsDTO;
import com.validations.service.ValidationsService;

@RestController
@RequestMapping(path = "/validation")

public class Controller {
	
	@Autowired
	ValidationsService services;
	
	@PostMapping(path = "/validateAnnotations")
	public ResponseEntity<Response> validations(@Valid @RequestBody ValidationsDTO dto) {
		Response response = services.validations(dto);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@PostMapping(path = "/validate1")
	public ResponseEntity<Response> validation_LoadActiontype(@RequestParam(name = "load") String loActType) {
		Response response = services.validation_LoadActiontype(loActType);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@PostMapping(path = "/validate2")
	public ResponseEntity<Response> validation_LoadCreateDOW(@RequestParam(name = "load") int loadCreaDOW) {
		Response response = services.validation_LoadCreateDOW(loadCreaDOW);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@PostMapping(path = "/validate3")
	public ResponseEntity<Response> validation_DestinationOrganizationCountryCode(@RequestParam(name = "destination") String desOrgCounCod) {
		Response response = services.validation_DestinationOrganizationCountryCode(desOrgCounCod);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@PostMapping(path = "/validate4")
	public ResponseEntity<Response> validation_DestinationOrganizationNumber(@RequestParam(name = "destination") String desOrgNum) {
		Response response = services.validation_DestinationOrganizationNumber(desOrgNum);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@PostMapping(path = "/validate5")
	public ResponseEntity<Response> validation_DestinationSortType(@RequestParam(name = "destination") String desSortType) {
		Response response = services.validation_DestinationSortType(desSortType);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@PostMapping(path = "/validate6")
	public ResponseEntity<Response> validation_ServiceTypeCodeMnemonicText(@RequestParam(name = "service") String serTyCoMnemTex) {
		Response response = services.validation_ServiceTypeCodeMnemonicText(serTyCoMnemTex);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@PostMapping(path = "/validate7")
	public ResponseEntity<Response> validation_LoadPieceQuantity(@RequestParam(name = "load") int loPiQuan) {
		Response response = services.validation_LoadPieceQuantity(loPiQuan);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@PostMapping(path = "/validate8")
	public ResponseEntity<Response> validation_LoadLatestPossibleArrivalTime(@RequestParam(name = "hr") String loadLatPoArrTime) {
		Response response = services.validation_LoadLatestPossibleArrivalTime(loadLatPoArrTime);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@PostMapping(path = "/validate9")
	public ResponseEntity<Response> validation_LoadLatestArrivalDayOfWeek(@RequestParam(name = "load") int ArrDayOfWeek) {
		Response response = services.validation_LoadLatestArrivalDayOfWeek(ArrDayOfWeek);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@PostMapping(path = "/validate10")
	public ResponseEntity<Response> validation_UnloadLoadDestinationCountryCode(@RequestParam(name = "unload") String unloadDestCounCod) {
		Response response = services.validation_UnloadLoadDestinationCountryCode(unloadDestCounCod);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@PostMapping(path = "/validate11")
	public ResponseEntity<Response> validation_RecordEffectiveEndDate(@RequestParam(name = "date") String reEffecEndDate) {
		Response response = services.validation_RecordEffectiveEndDate(reEffecEndDate);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

}
