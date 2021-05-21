package com.validations.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.validations.dto.Response;
import com.validations.dto.ValidationsDTO;
import com.validations.service.ValidationsService;

@RestController
@RequestMapping(path = "/validation")

public class Controller {
	
	@Autowired
	ValidationsService services;
	
	@PostMapping(path = "/validateDTO")
	public ResponseEntity<Response> validate(@Valid @RequestBody ValidationsDTO dto) {
		Response response = services.validations(dto);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

}
