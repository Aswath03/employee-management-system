package com.demo.ems.dto;

import java.util.Date;

import lombok.Data;

@Data
public class EmployeeRequestDTO {

	private String name;

	private Date dateOfBirth;

	private double salary;

	private String address;

	private String role;

	private Date joiningDate;

	private double bonusPercentage;

	private Long department;
	
	private Long reportingManager;

}
