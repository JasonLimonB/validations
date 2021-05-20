package com.validations.dto;


import java.sql.Time;
import java.time.LocalDate;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ValidationsDTO {
    // Put the attributes only
	
	@NotNull
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
	@NotNull
	private LocalDate recordEffectiveEndDate;

}
