package com.demo.ems.dto;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class DepartmentResponseDTO {
	
	private Long id ;

	private String departmentName;
	
	private String departmentHead;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date creationDate;
	
	private List<EmployeeDetailsDTO> employeeDetails= null;
	
}
