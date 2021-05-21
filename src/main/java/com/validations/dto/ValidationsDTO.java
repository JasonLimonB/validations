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

	@NotNull
	private String loadActionType;
	@NotNull
	private String loadNumberID;
	@NotNull
	private String recordEffectiveStartDate;
	@NotNull
	private int loadCreateDOW;
	@NotNull
	private String originOrganizationCountryCode;
	@NotNull
	private String originOrganizationNumber;
	@NotNull
	private String originSortType;
	@NotNull
	private String destinationOrganizationCountryCode;
	@NotNull
	private String destinationOrganizationNumber;
	@NotNull
	private String destinationSortType; 
	@NotNull
	private String serviceTypeCodeMnemonicText;
	@NotNull
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
	private int loadLatestArrivalDayOfWeek;
	private String unloadLoadDestinationCountryCode;
	private String unloadLoadDestinationOrganizationNumber;
	private String unloadLoadDestinationSortType;
	@NotNull
	private LocalDate recordEffectiveEndDate;


}
