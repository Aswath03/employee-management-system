package com.demo.ems.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.ems.dto.DepartmentRequestDTO;
import com.demo.ems.dto.DepartmentResponseDTO;
import com.demo.ems.service.DepartmentService;

import io.swagger.v3.oas.annotations.Operation;

@RequestMapping("department/")
@RestController
public class DepartmentController {

	@Autowired
	DepartmentService departmentService;

	@Operation(summary = "Create Department")
	@PostMapping(value = "create")
	public ResponseEntity<DepartmentResponseDTO> createDepartment(@RequestBody DepartmentRequestDTO requestDTO) {
		return ResponseEntity.ok(departmentService.createDepartment(requestDTO));
	}

	@Operation(summary = "Delete Department")
	@DeleteMapping(value = "delete")
	public ResponseEntity<String> deleteDepartment(@RequestParam("id") Long id) {
		Boolean res = departmentService.deleteDepartment(id);
		if (res == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Id not found : " + id);
		} else if (res == true) {
			return ResponseEntity.status(HttpStatus.OK).body("Department Deleted : " + id);
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body("Employees are assigned against this particular department !");
		}
	}

	@Operation(summary = "Update Department")
	@PutMapping(value = "update")
	public ResponseEntity<DepartmentResponseDTO> updateDepartment(@RequestParam("id") Long id,
			@RequestBody DepartmentRequestDTO requestDTO) {
		return ResponseEntity.ok(departmentService.updateDepartment(requestDTO, id));
	}

	@Operation(summary = "Fetch All Departments")
	@GetMapping(value = "getAllDepartments")
	public ResponseEntity<Map<String, Object>> getAllDepartments(
			@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "20") int size) {
		return ResponseEntity.ok(departmentService.getAllDepartments(page, size));
	}

	@Operation(summary = "Fetch Department And Their Employee")
	@GetMapping(value = "getDepartment")
	public ResponseEntity<DepartmentResponseDTO> getDepartment(@RequestParam("id") Long id,
			@RequestParam(name = "expand", required = false) String expand) {
		return ResponseEntity.ok(departmentService.getDepartment(id, expand));
	}

}
