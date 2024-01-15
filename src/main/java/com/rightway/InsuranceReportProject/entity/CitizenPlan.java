package com.rightway.InsuranceReportProject.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
public class CitizenPlan {

	@Id
	@GeneratedValue
	private int citizenId;
	private String citizenName;
	private String gender;
	private String planName;
	private String planStatus;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate startDate;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate endDate;
	private int benefitAmt;
	private String denialReason;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate terminatedDate;
	private String terminatedReason;
	
	
	public CitizenPlan(CitizenPlan citizen) {
		citizenName=citizen.getCitizenName();
		gender=citizen.getGender();
		planName=citizen.getPlanName();
		planStatus=citizen.getPlanStatus();
		startDate=citizen.getStartDate();
		endDate=citizen.getEndDate();
		benefitAmt=citizen.getBenefitAmt();
		denialReason=citizen.getDenialReason();
		terminatedDate=citizen.getTerminatedDate();
		terminatedReason=citizen.getTerminatedReason();
	}


	public CitizenPlan(int id, CitizenPlan citizen) {
		citizenId=id;
		citizenName=citizen.getCitizenName();
		gender=citizen.getGender();
		planName=citizen.getPlanName();
		planStatus=citizen.getPlanStatus();
		startDate=citizen.getStartDate();
		endDate=citizen.getEndDate();
		benefitAmt=citizen.getBenefitAmt();
		denialReason=citizen.getDenialReason();
		terminatedDate=citizen.getTerminatedDate();
		terminatedReason=citizen.getTerminatedReason();

	
	}
	
	
}
