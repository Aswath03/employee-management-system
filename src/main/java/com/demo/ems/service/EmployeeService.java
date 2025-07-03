package com.demo.ems.service;

import java.util.Map;

import com.demo.ems.dto.EmployeeRequestDTO;
import com.demo.ems.dto.EmployeeResponseDTO;

public interface EmployeeService {

	EmployeeResponseDTO createEmployee(EmployeeRequestDTO requestDTO);

	EmployeeResponseDTO updateEmployee(EmployeeRequestDTO requestDTO, Long id);

	EmployeeResponseDTO updateEmployeeDepartment(Long id, Long departmentId);

	Map<String, Object> getAllEmployees(int page, int size);

	Map<String, Object> getAllEmployeeIds(int page, int size, String lookup);



}
