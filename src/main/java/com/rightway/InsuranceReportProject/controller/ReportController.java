package com.rightway.InsuranceReportProject.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rightway.InsuranceReportProject.entity.CitizenPlan;
import com.rightway.InsuranceReportProject.entity.SearchRequest;
import com.rightway.InsuranceReportProject.service.IReportService;

@RestController
public class ReportController {

	@Autowired
	IReportService service;
	
	@PostMapping("/post")
	public CitizenPlan AddCitizen(@RequestBody CitizenPlan citizen) {
		CitizenPlan cAdd=service.AddCitizen(citizen);
		
		return cAdd;
	}
	
	@PutMapping("/put/{Id}")
	public CitizenPlan UpdateCitizen(@PathVariable int Id,@RequestBody CitizenPlan citizen) {
		CitizenPlan cAdd=service.EditCitizen(Id,citizen);
		
		return cAdd;
	}
	
	@GetMapping("/")
	public List<CitizenPlan> Citizens() {
		List<CitizenPlan> cAdd=service.CitizenList();
		
		return cAdd;
	}
	
	@GetMapping("/{Id}")
	public CitizenPlan CitizenByID(@PathVariable int Id) {
		CitizenPlan cAdd=service.FindCitizen(Id);
		
		return cAdd;
	}
	
	@GetMapping("/get")
	public List<CitizenPlan> CitizenByPlanName(@RequestParam String planName) {

		List<CitizenPlan> cAdd=service.CitizenPlanName(planName);
		
		return cAdd;
	}
	
	@GetMapping("/get1")
	public List<CitizenPlan> CitizenByPlanStatus(@RequestParam String planStatus) {
		List<CitizenPlan> cAdd=service.CitizenPlanStatus(planStatus);
		
		return cAdd;
	}
	
	@GetMapping("/search")
	public List<CitizenPlan> CitizenSearch(@RequestBody SearchRequest request) throws IOException {
		
		List<CitizenPlan> cAdd=service.CitizensSearch(request);
		
		return cAdd;
	}
	
	
	
	
	
}
