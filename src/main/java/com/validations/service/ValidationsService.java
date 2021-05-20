package com.validations.service;

import org.springframework.stereotype.Service;
import com.validations.dto.ValidationsDTO;


@Service
public class ValidationsService {

    // put the validations (methods)
	
	
	public boolean validation_LoadActiontype() {
		ValidationsDTO validDTO =  new ValidationsDTO();
		validDTO.setLoadActiontype("");  
		return (validDTO.getLoadActiontype().equals("ADD") || validDTO.getLoadActiontype().equals("UPDATE"))?  true : false;
	}
	
	public boolean validation_LoadCreateDOW() {
		ValidationsDTO validDTO =  new ValidationsDTO();
		validDTO.setLoadCreateDOW(1);
		return true;
	}

	

}
