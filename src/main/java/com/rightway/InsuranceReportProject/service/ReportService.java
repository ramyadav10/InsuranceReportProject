package com.rightway.InsuranceReportProject.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rightway.InsuranceReportProject.entity.CitizenPlan;
import com.rightway.InsuranceReportProject.entity.SearchRequest;
import com.rightway.InsuranceReportProject.repo.CitizenPlanRepo;
import com.rightway.InsuranceReportProject.utils.EmailSenderService;
import com.rightway.InsuranceReportProject.utils.ExportExcel;

@Service
public class ReportService  implements IReportService{

	@Autowired
	CitizenPlanRepo repo;
	
	@Autowired
	EmailSenderService sender;
	
	@Autowired
	ExportExcel exportExcel;
	
	@Override
	public CitizenPlan AddCitizen(CitizenPlan citizen) {
		CitizenPlan citizenAdd=new CitizenPlan(citizen);
		CitizenPlan citizenSaved=repo.save(citizenAdd);
		return citizenSaved;
	}

	@Override
	public CitizenPlan EditCitizen(int id, CitizenPlan citizen) {
		CitizenPlan citizenEdit=new CitizenPlan(id,citizen);
		repo.save(citizenEdit);
		return citizenEdit;
			
	}

	@Override
	public List<CitizenPlan> CitizenList() {
		
		return repo.findAll();
	}

	@Override
	public CitizenPlan FindCitizen(int id) {
		Optional<CitizenPlan> citizen=repo.findById(id);
		return citizen.get();
	}

	@Override
	public List<CitizenPlan> CitizenPlanName(String planName) {
		List<CitizenPlan> citizen=repo.findByPlanName(planName);
		return citizen;
	}

	@Override
	public List<CitizenPlan> CitizenPlanStatus(String planStatus) {
		List<CitizenPlan> citizen=repo.findByPlanStatus(planStatus);
		return citizen;
	}

	@Override
	public List<CitizenPlan> CitizensSearch(SearchRequest request) throws IOException {
		List<CitizenPlan> citizens=repo.findAll(request.getPlanName(),request.getPlanStatus(),
				request.getGender(),request.getStartDate(), request.getEndDate());
		exportExcel.ExcelGenerator(citizens);
		return citizens;
	}
	

}
