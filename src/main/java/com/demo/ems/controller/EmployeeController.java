package com.demo.ems.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.ems.dto.EmployeeRequestDTO;
import com.demo.ems.dto.EmployeeResponseDTO;
import com.demo.ems.service.EmployeeService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("employee/")
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	@Operation(summary = "Create Employee")
	@PostMapping(value = "create")
	public ResponseEntity<EmployeeResponseDTO> createEmployee(@RequestBody EmployeeRequestDTO requestDTO){
		return ResponseEntity.ok(employeeService.createEmployee(requestDTO));	
	}
	
	@Operation(summary = "Update Employee Details")
	@PutMapping(value = "update")
	public ResponseEntity<EmployeeResponseDTO> updateEmployee(@RequestParam("id") Long id, @RequestBody EmployeeRequestDTO requestDTO){
		return ResponseEntity.ok(employeeService.updateEmployee(requestDTO, id));	
	}
	
	@Operation(summary = "Update Employees Department")
	@PutMapping(value = "updateDepartment")
	public ResponseEntity<EmployeeResponseDTO> updateEmployeeDepartment(@RequestParam("id") Long id, @RequestParam("departmentId") Long departmentId){
		return ResponseEntity.ok(employeeService.updateEmployeeDepartment(id, departmentId));	
	}
	
	@Operation(summary = "Fetch All Employees")
	@GetMapping(value = "getAllEmployees")
	public ResponseEntity<Map<String, Object>> getAllEmployees(@RequestParam(name = "page",defaultValue = "0") int page,
			@RequestParam(name="size",defaultValue = "20") int size){
		return ResponseEntity.ok(employeeService.getAllEmployees(page, size));	
	}	
	
	@Operation(summary = "Fetch All Employees And Ids ")
	@GetMapping(value = "getAllEmployeeIds")
	public ResponseEntity<Map<String, Object>> getAllEmployeeIds(@RequestParam(name = "page",defaultValue = "0") int page,
			@RequestParam(name="size",defaultValue = "20") int size,@RequestParam(required = false, name="lookup") String lookup){
		return ResponseEntity.ok(employeeService.getAllEmployeeIds(page, size,lookup));	
	}	

}
