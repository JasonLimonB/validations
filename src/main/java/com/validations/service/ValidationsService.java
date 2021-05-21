package com.validations.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.validations.dto.ValidationsDTO;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class ValidationsService {

    @Autowired
    private ValidationsDTO validDTO;
    private Pattern pattern;
    private Matcher matcher;
	
	public boolean validation_LoadActiontype() {
		validDTO.setLoadActionType("");
		return validDTO.getLoadActionType().equals("ADD") || validDTO.getLoadActionType().equals("UPDATE");
	}
	
	public boolean validation_LoadCreateDOW() {
		validDTO.setLoadCreateDOW(1);
		return true;
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
