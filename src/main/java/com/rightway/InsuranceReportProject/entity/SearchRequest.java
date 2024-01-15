package com.rightway.InsuranceReportProject.entity;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SearchRequest {

	private String planName;
	private String planStatus;
	private String gender;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate startDate;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate endDate;	
}
