package com.validations.service;

import org.springframework.stereotype.Service;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class ValidationsService {

    private Pattern pattern;
    private Matcher matcher;

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

    private boolean originOrganizationCountryCode( String value ){
        if( value == null ) return false;
        return value.length() == 2;
    }

}
