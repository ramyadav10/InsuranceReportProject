package com.rightway.InsuranceReportProject.repo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.rightway.InsuranceReportProject.entity.CitizenPlan;
import com.rightway.InsuranceReportProject.entity.SearchRequest;

@Repository
public interface CitizenPlanRepo extends JpaRepository<CitizenPlan, Integer> {
	List<CitizenPlan> findByPlanName(String planName);

	List<CitizenPlan> findByPlanStatus(String planStatus);

	 @Query(value="select * from citizen_plan where "
	 		+ "(plan_name =:planName or :planName = '' or :planName is null) and "
	 		+ "(plan_status =:planStatus or :planStatus = ''or :planStatus is null) and "
	 		+ "(gender =:gender or :gender = '' or :gender is null) and "
	 		+ "(start_date =:startDate or :startDate is null) and "
	 		+ "(end_date =:endDate or :endDate is null)", nativeQuery=true)
	List<CitizenPlan> findAll(String planName, String planStatus, String gender, LocalDate startDate,
			LocalDate endDate);

}
