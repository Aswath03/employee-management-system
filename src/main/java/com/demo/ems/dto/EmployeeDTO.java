package com.demo.ems.dto;

import java.util.Date;

public interface EmployeeDTO {
	
	Long getId();
	
	String getName();
	
	Date getDob();
	
	double getSalary();
	
	String getAddress();
	
	String getRole();
	
	Date getJoiningDate();
	
	double getBonusPercentage();
	
	String getDepartment();
	
	String getReportingManager();
}
