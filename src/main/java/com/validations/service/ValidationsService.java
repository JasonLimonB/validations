package com.validations.service;


import org.springframework.stereotype.Service;

import com.validations.dto.Response;
import com.validations.dto.ValidationsDTO;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
@Slf4j
public class ValidationsService {

    //@Autowired
    private ValidationsDTO validDTO;
    private Pattern pattern;
    private Matcher matcher;
    
    public Response errorResponse(String message) {
    	return new Response(false, message, null);
    }
    
    public Response validations(ValidationsDTO dto) {
    	Response response = new Response();
		response.setData(dto);
		return response;
	}    
	
    public Response validation_LoadActiontype(String loActType) {
    	Response response = new Response();
		ValidationsDTO validDTO =  new ValidationsDTO();
		try {
			if (loActType.equals("ADD") || loActType.equals("UPDATE")) {
				validDTO.setLoadActiontype(loActType);
				response.setData(validDTO.getLoadActiontype());
				return response;
			}
			return errorResponse("Invalid LoadActiontype");
		}catch (Exception e) {
			log.error("{}", e.getMessage());
			return errorResponse("Exception: "+e);
		}
	}
	
	public Response validation_LoadCreateDOW(Integer loadCreaDOW) {
		Response response = new Response();
		ValidationsDTO validDTO =  new ValidationsDTO();
		try {
			pattern = Pattern.compile("[1-7]{1,1}");
			matcher = pattern.matcher(Integer.toString(loadCreaDOW));
			if (matcher.matches()) {
				validDTO.setLoadCreateDOW(loadCreaDOW);
				response.setData(validDTO.getLoadCreateDOW());
				return response;			
			}
			return errorResponse("Invalid LoadCreateDOW");
		}catch (Exception e) {
			log.error("{}", e.getMessage());
			return errorResponse("Exception: "+e);
		}
	}
    
	public Response validation_DestinationOrganizationCountryCode(String desOrgCounCod) {
		Response response = new Response();
		ValidationsDTO validDTO =  new ValidationsDTO();
		try {
			pattern = Pattern.compile("[a-zA-Z]{2,2}");
			matcher = pattern.matcher(desOrgCounCod);
			if (matcher.matches()) {
				validDTO.setDestinationOrganizationCountryCode(desOrgCounCod);
				response.setData(validDTO.getDestinationOrganizationCountryCode());
				return response;			
			}
			return errorResponse("Invalid DestinationOrganizationCountryCode");
		}catch (Exception e) {
			log.error("{}", e.getMessage());
			return errorResponse("Exception: "+e);
		}
	}
	
	public Response validation_DestinationOrganizationNumber(String desOrgNum) {
		Response response = new Response();
		ValidationsDTO validDTO =  new ValidationsDTO();
		try { 
			pattern = Pattern.compile("\\w{1,5}");
			matcher = pattern.matcher(desOrgNum);
			if (matcher.matches()) {
				validDTO.setDestinationOrganizationNumber(desOrgNum);
				response.setData(validDTO.getDestinationOrganizationNumber());
				return response;			
			}
			return errorResponse("Invalid DestinationOrganizationNumber");
		}catch (Exception e) {
			log.error("{}", e.getMessage());
			return errorResponse("Exception: "+e);
		}
	}
	
	public Response validation_DestinationSortType(String desSortType) {
		Response response = new Response();
		ValidationsDTO validDTO =  new ValidationsDTO();
		if(desSortType != null) { 
			Map<String, String> sortType = new HashMap<>();
			sortType.put("A","AFTERNOON");	
			sortType.put("C","CPU-CENTRAL PICK UP");
			sortType.put("D","DAY");
			sortType.put("E","EMPTY");
			sortType.put("L","LOCAL");
			sortType.put("M","MORNING");
			sortType.put("N","NIGHT");
			sortType.put("P","PRELOAD");
			sortType.put("S","SUNRISE");
			sortType.put("T","TWILIGHT");
			if (sortType.containsKey(desSortType)) {
				response.setData(validDTO);
				return response;			
			}
			return errorResponse("Invalid DestinationSortType");
		}
		return errorResponse("Invalid, DestinationSortType can't be null");
	}
	
	public Response validation_ServiceTypeCodeMnemonicText(String serTyCoMnemTex) {
		Response response = new Response();
		ValidationsDTO validDTO =  new ValidationsDTO();
		if(serTyCoMnemTex != null) {
			HashSet<String> mnemonicText = new HashSet<>();
			mnemonicText.add("1DA");	
			mnemonicText.add("2DA");
			mnemonicText.add("3DS");
			mnemonicText.add("GND");	
			mnemonicText.add("GRD");
			mnemonicText.add("EAM");
			mnemonicText.add("DH1");	
			mnemonicText.add("DH2");
			mnemonicText.add("E");
			mnemonicText.add("G");	
			mnemonicText.add("3");
			mnemonicText.add("N");
			mnemonicText.add("S");
			mnemonicText.add("I");
			if (mnemonicText.contains(serTyCoMnemTex)) {
				validDTO.setServiceTypeCodeMnemonicText(serTyCoMnemTex);
				response.setData(validDTO.getServiceTypeCodeMnemonicText());
				return response;			
			}
			return errorResponse("Invalid ServiceTypeCodeMnemonicText");
		}
			return errorResponse("ServiceTypeCodeMnemonicText can't be null");
	}
	
	public Response validation_LoadPieceQuantity(Integer loPiQuan) {
		Response response = new Response();
		ValidationsDTO validDTO =  new ValidationsDTO();
		try {
			pattern = Pattern.compile("[0-9]{1,4}"); 
			matcher = pattern.matcher(Integer.toString(loPiQuan));
			if (matcher.matches()) {
				validDTO.setLoadPieceQuantity(loPiQuan);
				response.setData(validDTO.getLoadPieceQuantity());
				return response;			
			}
			return errorResponse("Invalid LoadPieceQuantity");
		}catch (Exception e) {
			log.error("{}", e.getMessage());
			return errorResponse("Exception: "+e);
		}
	}
	
	public Response validation_LoadLatestPossibleArrivalTime(String loadLatPoArrTime) {
		Response response = new Response();
		ValidationsDTO validDTO =  new ValidationsDTO();
		pattern = Pattern.compile("(0[0-9]|1[0-9]|2[0-3]):[0-5][0-9]$");
		matcher = pattern.matcher(loadLatPoArrTime);
		if (matcher.matches()) {
			validDTO.setLoadLatestPossibleArrivalTime(LocalTime.parse(loadLatPoArrTime));
			response.setData(validDTO.getLoadLatestPossibleArrivalTime());
			return response;			
		}
		return errorResponse("Invalid LoadLatestPossibleArrivalTime");	
	}
		
	public Response validation_LoadLatestArrivalDayOfWeek(int ArrDayOfWeek) {
		Response response = new Response();
		ValidationsDTO validDTO =  new ValidationsDTO();
		pattern = Pattern.compile("[1-7]{1,1}");
		matcher = pattern.matcher(Integer.toString(ArrDayOfWeek));
		if (matcher.matches()) {
			validDTO.setLoadLatestArrivalDayOfWeek(ArrDayOfWeek);
			response.setData(validDTO.getLoadLatestArrivalDayOfWeek());
			return response;			
		}
		return errorResponse("Invalid LoadLatestArrivalDayOfWeek");	
	}
	
	public Response validation_UnloadLoadDestinationCountryCode(String unloadDestCounCod) {
		Response response = new Response();
		ValidationsDTO validDTO =  new ValidationsDTO();
		pattern = Pattern.compile("[a-zA-Z]{2,2}");
		matcher = pattern.matcher(unloadDestCounCod);
		if (matcher.matches()) {
			validDTO.setUnloadLoadDestinationCountryCode(unloadDestCounCod);
			response.setData(validDTO.getUnloadLoadDestinationCountryCode());
			return response;			
		}
		return errorResponse("Invalid UnloadLoadDestinationCountryCode");		
	}
	
	
	public Response validation_RecordEffectiveEndDate(String reEffecEndDate) {
		Response response = new Response();
		ValidationsDTO validDTO =  new ValidationsDTO();
		try {
			pattern = Pattern.compile("^(((19|2[0-9])[0-9]{2})-(0[13578]|10|12)-(0[1-9]|[12][0-9]|3[01]))$"  + 
									  "|^(((19|2[0-9])[0-9]{2})-(0[469]|11)-(0[1-9]|[12][0-9]|30))$");
	        matcher = pattern.matcher(reEffecEndDate);
	        if (matcher.matches()) {
	        	validDTO.setRecordEffectiveEndDate(LocalDate.parse(reEffecEndDate));
	        	response.setData(validDTO.getRecordEffectiveEndDate());
				return response;			
			}
			return errorResponse("Invalid RecordEffectiveEndDate");
		}catch (Exception e) {
			log.error("{}", e.getMessage());
			return errorResponse("Exception: "+e);
		}
	}

    public boolean isValidLoadNumberID( String numberId ){
        if( numberId == null ) return false;
        pattern = Pattern.compile("\\w{6,20}");
        matcher = pattern.matcher(numberId);
        return matcher.matches();
    }

    public boolean isValidRecordEffectiveStartDate( String date ){
        if( date == null ) return false;
        pattern = Pattern.compile("\\d{4}/\\d{2}/\\d{2}");
        matcher = pattern.matcher(date);
        return matcher.matches();
    }

    public boolean isValidOriginOrganizationCountryCode( String value ){
        if( value == null ) return false;
        return value.length() == 2;
    }

    public boolean isValidOriginOrganizationNumber( String value ){
	    if( value == null || value.isEmpty()) return false;
	    return value.length() > 1 && value.length() <= 6;
    }

    public boolean isValidRiginSortType(String value){
	    if( value == null ) return false;
        Map<String, String> allow = new HashMap<>(10);
        allow.put("A","AFTERNOON");
        allow.put("C","CPU-CENTRAL PICK UP");
        allow.put("D","DAY");
        allow.put("E","EMPTY");
        allow.put("L","LOCAL");
        allow.put("M","MORNING");
        allow.put("N","NIGHT");
        allow.put("P","PRELOAD");
        allow.put("S","SUNRISE");
        allow.put("T","TWILIGHT");
        return allow.containsKey(value);
    }

    public boolean isValidLoadRouteCode( String value ){
	    if ( value == null ) return false;
	    return value.length() == 1 || value.length() == 2;
    }

    public boolean isValidEquipmentTrailerTypeCode(String value){
	    if (value == null) return false;
        pattern = Pattern.compile("\\w{1,3}");
        matcher = pattern.matcher(value);
        return matcher.matches();
    }

    public boolean isValidLoadVolumeUtilizationPercent(Integer value){
        if (value == null) return false;
        pattern = Pattern.compile("\\w{1,4}");
        matcher = pattern.matcher(value.toString());
        return matcher.matches();
    }

    public boolean isValidLoadEarliestPossibleDepartureTimestamp( String date ){
        pattern = Pattern.compile("\\d{2}:\\d{2}");
        matcher = pattern.matcher(date);
        return matcher.matches();
    }

    public boolean isValidLoadEarliestDepartureDayOfWeek( Integer day ){
	    return day >=1 && day <=7;
    }

    public boolean isValidUnloadLoadDestinationOrganizationNumber( String value  ){
        pattern = Pattern.compile("\\w{1,5}");
        matcher = pattern.matcher(value);
        return matcher.matches();
    }

    public boolean isValidUnloadLoadDestinationSortType( String value ){
        Map<String, String> allow = new HashMap<>(10);
        allow.put("A","AFTERNOON");
        allow.put("C","CPU-CENTRAL PICK UP");
        allow.put("D","DAY");
        allow.put("E","EMPTY");
        allow.put("L","LOCAL");
        allow.put("M","MORNING");
        allow.put("N","NIGHT");
        allow.put("P","PRELOAD");
        allow.put("S","SUNRISE");
        allow.put("T","TWILIGHT");
        return allow.containsKey(value);
    }

	
}
