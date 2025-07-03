package com.demo.ems.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class EmployeeResponseDTO {
	
	private Long id ;

	private String name;

	private Date dateOfBirth;

	private double salary;

	private String address;

	private String role;

	private Date joiningDate;

	private double bonusPercentage;

	private String department;
	
	private String reportingManager;
}
