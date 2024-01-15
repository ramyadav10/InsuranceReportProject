package com.rightway.InsuranceReportProject.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;
import org.apache.poi.ss.usermodel.Row;
import com.rightway.InsuranceReportProject.entity.CitizenPlan;

@Component
public class ExportExcel {

	
	public void ExcelGenerator(List<CitizenPlan> citizens) throws IOException {
	Workbook workbook = new XSSFWorkbook();
	Sheet sheet = workbook.createSheet("CitizenList");
	
	Row headerRow = sheet.createRow(0);

	headerRow.createCell(0).setCellValue("Citizen.No");
	headerRow.createCell(1).setCellValue("Name");
	headerRow.createCell(2).setCellValue("Gender");
	headerRow.createCell(3).setCellValue("Plan Name");
	headerRow.createCell(4).setCellValue("Plan Status");
	int rowIndex=0;
	
	for (CitizenPlan citizen : citizens) {
	  Row dataRow = sheet.createRow(rowIndex++);

	  dataRow.createCell(0).setCellValue( citizen.getCitizenId());
	  dataRow.createCell(1).setCellValue(citizen.getCitizenName());
	  dataRow.createCell(2).setCellValue(citizen.getGender());
	  dataRow.createCell(3).setCellValue(citizen.getPlanName());
	  dataRow.createCell(4).setCellValue(citizen.getPlanStatus());
	}

	ByteArrayOutputStream out = new ByteArrayOutputStream();
	workbook.write(out);
	  workbook.close();
      out.close();
      System.out.println(workbook);
      
	
	}
}
