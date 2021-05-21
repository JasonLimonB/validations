package com.validations.dto;

import java.sql.Time;
import java.time.LocalDate;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ValidationsDTO {

    // Put the attributes only
	
	@NotNull(message = "null")
	private String loadActiontype;
	@NotNull
	private int loadCreateDOW;
	@NotNull
	private String destinationOrganizationCountryCode;
	@NotNull
	private String destinationOrganizationNumber;
	@NotNull
	private String destinationSortType; 
	@NotNull
	private String serviceTypeCodeMnemonicText;
	@NotNull
	private int loadPieceQuantity;
	private Time loadLatestPossibleArrivalTime;
	private int loadLatestArrivalDayOfWeek;
	private String unloadLoadDestinationCountryCode;
	//@NotNull
	private LocalDate recordEffectiveEndDate;
	
	
    private String loadActionType;
    private String loadNumberID;
}
