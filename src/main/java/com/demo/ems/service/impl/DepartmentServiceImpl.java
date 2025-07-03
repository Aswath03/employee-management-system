package com.demo.ems.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.demo.ems.dto.DepartmentDTO;
import com.demo.ems.dto.DepartmentRequestDTO;
import com.demo.ems.dto.DepartmentResponseDTO;
import com.demo.ems.dto.EmployeeDetailsDTO;
import com.demo.ems.entity.Department;
import com.demo.ems.entity.Employee;
import com.demo.ems.repo.DepartmentRepository;
import com.demo.ems.repo.EmployeeRepository;
import com.demo.ems.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	DepartmentRepository departmentRepository;
	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public DepartmentResponseDTO createDepartment(DepartmentRequestDTO requestDTO) {
		if (requestDTO != null) {
			try {
				Department department = new Department();
				department.setDepartmentName(requestDTO.getDepartmentName());
				department.setDepartmentHead(new Employee());
				department.getDepartmentHead().setId(requestDTO.getDepartmentHead());
				department.setCreationDate(new Date());

				departmentRepository.save(department);

				DepartmentResponseDTO response = getResponse(department);

				return response;

			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException("Error while creating department");
			}
		}
		return null;
	}

	@Override
	public DepartmentResponseDTO updateDepartment(DepartmentRequestDTO requestDTO, Long id) {
		if (requestDTO != null && id != null) {
			try {
				Optional<Department> optional = departmentRepository.findById(id);
				if (optional.isPresent()) {
					Department department = optional.get();
					department.setDepartmentName(requestDTO.getDepartmentName());

					departmentRepository.save(department);

					DepartmentResponseDTO response = getResponse(department);

					return response;
				}

			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException("Error while updating department");
			}
		}
		return null;
	}

	public DepartmentResponseDTO getResponse(Department department) {
		if (department != null) {
			try {
				DepartmentResponseDTO response = new DepartmentResponseDTO();
				response.setId(department.getId());
				response.setDepartmentName(department.getDepartmentName());
				if (department.getDepartmentHead() != null && department.getDepartmentHead().getName() != null) {
					response.setDepartmentHead(department.getDepartmentHead().getName());
				} else if (department.getDepartmentHead() != null) {
					response.setDepartmentHead(department.getDepartmentHead().getId().toString());
				}
				response.setCreationDate(department.getCreationDate());

				return response;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;

	}

	@Override
	public Boolean deleteDepartment(Long id) {
		if (id != null) {
			try {
				Optional<Department> optional = departmentRepository.findById(id);
				if (optional.isPresent()) {
					List<Employee> employee = employeeRepository.findByDepartmentId(id);
					if (!employee.isEmpty()) {
						return false;
					} else {
						departmentRepository.deleteById(id);
						return true;
					}
				}

			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException("Error while deleting department");
			}
		}
		return null;
	}

	@Override
	public Map<String, Object> getAllDepartments(int page, int size) {
		try {
			Pageable pageable = PageRequest.of(page, size);
			Page<DepartmentDTO> department = departmentRepository.findAllDetails(pageable);

			Map<String, Object> response = new HashMap<>();
			response.put("employees", department.getContent());
			response.put("currentPage", department.getNumber());
			response.put("totalPages", department.getTotalPages());
			response.put("totalItems", department.getTotalElements());
			return response;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Error while fetching department details");
		}
	}

	@Override
	public DepartmentResponseDTO getDepartment(Long id, String expand) {
		if (id != null) {
			try {
				Optional<Department> optional = departmentRepository.findById(id);
				if (optional.isPresent()) {
					Department department = optional.get();
					DepartmentResponseDTO dto = new DepartmentResponseDTO();
					if (department.getDepartmentName() != null && !department.getDepartmentName().isEmpty()) {
						dto.setDepartmentName(department.getDepartmentName());
					}
					if (department.getDepartmentHead() != null && department.getDepartmentHead().getName() != null) {
						dto.setDepartmentHead(department.getDepartmentHead().getName());
					}
					dto.setCreationDate(department.getCreationDate());

					if (expand != null && expand.equals("true")) {
						List<EmployeeDetailsDTO> employeeDetailsDTOs = department.getEmployees().stream()
							    .map(emp -> {
							        EmployeeDetailsDTO empDto = new EmployeeDetailsDTO();
							        empDto.setId(emp.getId());
							        empDto.setName(emp.getName());
							        return empDto;
							    })
							    .collect(Collectors.toList());
						dto.setEmployeeDetails(employeeDetailsDTOs);
					}
					return dto;
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException("Error while fetching department details");
			}
		}
		return null;
	}

}
