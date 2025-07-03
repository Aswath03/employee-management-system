package com.demo.ems.service;

import java.util.Map;

import com.demo.ems.dto.DepartmentRequestDTO;
import com.demo.ems.dto.DepartmentResponseDTO;

public interface DepartmentService {

	DepartmentResponseDTO createDepartment(DepartmentRequestDTO requestDTO);

	DepartmentResponseDTO updateDepartment(DepartmentRequestDTO requestDTO, Long id);

	Boolean deleteDepartment(Long id);

	Map<String, Object> getAllDepartments(int page, int size);

	DepartmentResponseDTO getDepartment(Long id, String expand);

}
