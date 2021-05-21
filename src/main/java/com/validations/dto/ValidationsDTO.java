package com.validations.dto;

import java.time.LocalDate;
import java.time.LocalTime;

<<<<<<< HEAD
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
=======
import javax.validation.constraints.NotNull;
>>>>>>> f71df774104fc1fe1ada88c07e0edeee22c88729

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ValidationsDTO {

<<<<<<< HEAD
    // Put the attributes only
	
	@NotNull(message = "loadActiontype couldn't be null")
	@NotEmpty
	@Pattern(regexp = "^ADD|UPDATE$", message = "Invalid loadActiontype")
	private String loadActiontype;
	
=======

	@NotNull
	private String loadActionType;
	@NotNull
	private String loadNumberID;
	@NotNull
	private String recordEffectiveStartDate;
>>>>>>> f71df774104fc1fe1ada88c07e0edeee22c88729
	@NotNull
	@DecimalMin(value = "1", message = "loadCreateDOW needs to be between 1-7")
	@DecimalMax(value = "7", message = "loadCreateDOW needs to be between 1-7")
	private int loadCreateDOW;
	
	@NotNull
<<<<<<< HEAD
	@Pattern(regexp = "[a-zA-Z]{2,2}",message = "Invalid destinationOrganizationCountryCode")
=======
	private String originOrganizationCountryCode;
	@NotNull
	private String originOrganizationNumber;
	@NotNull
	private String originSortType;
	@NotNull
>>>>>>> f71df774104fc1fe1ada88c07e0edeee22c88729
	private String destinationOrganizationCountryCode;
	
	@NotNull
	@Pattern(regexp = "\\w{1,5}", message = "Invalid destinationOrganizationNumber")
	private String destinationOrganizationNumber;
	
	@NotNull
	private DestinationSortType destinationSortType; 
	
	@NotNull
	@NotEmpty
	@Pattern(regexp = "^1DA|2DA|3DS|GND|GRD|EAM|DH1|DH2|E|G|3|N|S|I$", message = "Invalid serviceTypeCodeMnemonicText")
	private String serviceTypeCodeMnemonicText;
	
	@NotNull
<<<<<<< HEAD
	@Digits(integer = 4, fraction = 0, message = "Invalid loadPieceQuantity")
	private int loadPieceQuantity;
	
	@DateTimeFormat(iso = ISO.TIME, fallbackPatterns = "HH:MM")
	private LocalTime loadLatestPossibleArrivalTime;
	
	@DecimalMin(value = "1", message = "loadLatestArrivalDayOfWeek needs to be between 1-7")
	@DecimalMax(value = "7", message = "loadLatestArrivalDayOfWeek needs to be between 1-7")
=======
	private String loadRouteCode;
	@NotNull
	private  String equipmentTrailerTypeCode;
	@NotNull
	private Integer loadPieceQuantity;
	@NotNull
	private Integer loadVolumeUtilizationPercent;
	private Time loadEarliestPossibleDepartureTimestamp;
	private Integer loadEarliestDepartureDayOfWeek;
	private Time loadLatestPossibleArrivalTime;
>>>>>>> f71df774104fc1fe1ada88c07e0edeee22c88729
	private int loadLatestArrivalDayOfWeek;
	
	@Pattern(regexp = "[a-zA-Z]{2,2}", message = "Invalid unloadLoadDestinationCountryCode")
	private String unloadLoadDestinationCountryCode;
<<<<<<< HEAD
	
	@NotNull
	@DateTimeFormat(iso = ISO.DATE, fallbackPatterns = "YYYY-MM-DD")
	private LocalDate recordEffectiveEndDate;
	
	
	private enum DestinationSortType{
		A,C,D,E,L,M,N,P,S,T
	}
	
    private String loadActionType;
    private String loadNumberID;
=======
	private String unloadLoadDestinationOrganizationNumber;
	private String unloadLoadDestinationSortType;
	@NotNull
	private LocalDate recordEffectiveEndDate;


>>>>>>> f71df774104fc1fe1ada88c07e0edeee22c88729
}
