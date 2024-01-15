package com.rightway.InsuranceReportProject.service;

import java.io.IOException;
import java.util.List;

import com.rightway.InsuranceReportProject.entity.CitizenPlan;
import com.rightway.InsuranceReportProject.entity.SearchRequest;

public interface IReportService {

	CitizenPlan AddCitizen(CitizenPlan citizen);

	CitizenPlan EditCitizen(int id, CitizenPlan citizen);

	List<CitizenPlan> CitizenList();

	CitizenPlan FindCitizen(int id);

	List<CitizenPlan> CitizenPlanName(String planName);

	List<CitizenPlan> CitizenPlanStatus(String planStatus);

	List<CitizenPlan> CitizensSearch(SearchRequest request) throws IOException;

}
