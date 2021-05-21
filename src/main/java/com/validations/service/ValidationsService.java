package com.validations.service;

import org.springframework.stereotype.Service;

import com.validations.dto.Response;
import com.validations.dto.ValidationsDTO;
import lombok.extern.slf4j.Slf4j;
import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
@Slf4j
public class ValidationsService {

	private Pattern pattern;
    private Matcher matcher;
    // put the validations (methods)	
    
    public Response validations(ValidationsDTO dto) {
		Response response = new Response();
		response.setData(dto);
		return response;
	}
	
	public boolean validation_LoadActiontype(String value) {
		ValidationsDTO validDTO =  new ValidationsDTO();
		try {
			if (value.equals("ADD") || value.equals("UPDATE")) {
				validDTO.setLoadActiontype(value);
				return true;
			}
			return false;
		}catch (Exception e) {
			log.error("{}", e.getMessage());
			return false;
		}
	}
	
	public boolean validation_LoadCreateDOW(int loadCreaDOW) {
		ValidationsDTO validDTO =  new ValidationsDTO();
		try {
			pattern = Pattern.compile("[1-7]{1,1}");
			matcher = pattern.matcher(Integer.toString(loadCreaDOW));
			if (matcher.matches()) {
				validDTO.setLoadCreateDOW(loadCreaDOW);
				return true;			
			}
			return false;
		}catch (Exception e) {
			log.error("{}", e.getMessage());
			return false;
		}
	}
    
	public boolean validation_DestinationOrganizationCountryCode(String desOrgCounCod) {
		ValidationsDTO validDTO =  new ValidationsDTO();
		try {
			pattern = Pattern.compile("[a-zA-Z]{2,2}");
			matcher = pattern.matcher(desOrgCounCod);
			if (matcher.matches()) {
				validDTO.setDestinationOrganizationCountryCode(desOrgCounCod);
				return true;
			}
			return false;	
		}catch (Exception e) {
			log.error("{}", e.getMessage());
			return false;
		}
	}
	
	public boolean validation_DestinationOrganizationNumber(String desOrgNum) {
		ValidationsDTO validDTO =  new ValidationsDTO();
		try { 
			pattern = Pattern.compile("\\w{1,5}");
			matcher = pattern.matcher(desOrgNum);
			if (matcher.matches()) {
				validDTO.setDestinationOrganizationNumber(desOrgNum);
				return true;
			}
			return false;	
		}catch (Exception e) {
			log.error("{}", e.getMessage());
			return false;
		}
	}	
	
	public boolean validation_LoadPieceQuantity(int loPiQuan) {
		ValidationsDTO validDTO =  new ValidationsDTO();
		try {
			pattern = Pattern.compile("[0-9]{1,4}"); 
			matcher = pattern.matcher(Integer.toString(loPiQuan));
			if (matcher.matches()) {
				validDTO.setLoadCreateDOW(loPiQuan);
				return true;			
			}
			return false;			
		}catch (Exception e) {
			log.error("{}", e.getMessage());
			return false;
		}
	}
	
	
	public boolean validation_LoadLatestArrivalDayOfWeek(int ArrDayOfWeek) {
		ValidationsDTO validDTO =  new ValidationsDTO();
		pattern = Pattern.compile("[1-7]{1,1}");
		matcher = pattern.matcher(Integer.toString(ArrDayOfWeek));
		if (matcher.matches()) {
			validDTO.setLoadLatestArrivalDayOfWeek(ArrDayOfWeek);
			return true;			
		}
		return false;		
	}
	
	public boolean validation_UnloadLoadDestinationCountryCode(String unloadDestCounCod) {
		ValidationsDTO validDTO =  new ValidationsDTO();
		pattern = Pattern.compile("[a-zA-Z]{2,2}");
		matcher = pattern.matcher(unloadDestCounCod);
		if (matcher.matches()) {
			validDTO.setUnloadLoadDestinationCountryCode(unloadDestCounCod);
			return true;			
		}
		return false;		
	}
	
	public boolean validation_RecordEffectiveEndDate(LocalDate reEffecEndDate) {
		ValidationsDTO validDTO =  new ValidationsDTO();
		try {
			pattern = Pattern.compile("^(((19|2[0-9])[0-9]{2})-(0[13578]|10|12)-(0[1-9]|[12][0-9]|3[01]))$"  + "|^(((19|2[0-9])[0-9]{2})-(0[469]|11)-(0[1-9]|[12][0-9]|30))$");
	        matcher = pattern.matcher(reEffecEndDate.toString());
	        System.out.println(reEffecEndDate);
	        if (matcher.matches()) {
	        	validDTO.setRecordEffectiveEndDate(reEffecEndDate);
				return true;
			}
			return false;
		}catch (Exception e) {
			log.error("{}", e.getMessage());
			return false;
		}
	}

    public boolean isValidLoadNumberID( String numberId ){
        if( numberId == null ) return false;
        pattern = Pattern.compile("\\w{6,20}");
        matcher = pattern.matcher(numberId);
        return matcher.matches();
    }

    public boolean recordEffectiveStartDate( String date ){
        if( date == null ) return false;
        pattern = Pattern.compile("\\d{4}/\\d{2}/\\d{2}");
        matcher = pattern.matcher(date);
        return matcher.matches();
    }

	

}
