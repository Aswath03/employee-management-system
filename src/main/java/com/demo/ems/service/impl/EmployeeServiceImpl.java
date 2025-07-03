package com.demo.ems.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.ems.dto.EmployeeDTO;
import com.demo.ems.dto.EmployeeDetailsDTO;
import com.demo.ems.dto.EmployeeRequestDTO;
import com.demo.ems.dto.EmployeeResponseDTO;
import com.demo.ems.entity.Department;
import com.demo.ems.entity.Employee;
import com.demo.ems.repo.EmployeeRepository;
import com.demo.ems.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	@Transactional
	public EmployeeResponseDTO createEmployee(EmployeeRequestDTO requestDTO) {

		if (requestDTO != null) {
			try {
				Employee employee = new Employee();

				BeanUtils.copyProperties(requestDTO, employee, "department", "reportingManager");

				if (requestDTO.getDepartment() != null) {
					employee.setDepartment(new Department());
					employee.getDepartment().setId(requestDTO.getDepartment());
				}
				if (requestDTO.getReportingManager() != null) {
					employee.setReportingManager(new Employee());
					employee.getReportingManager().setId(requestDTO.getReportingManager());
				}

				employeeRepository.save(employee);
				
				EmployeeResponseDTO response = getResponse(employee);
				return response;

			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException("Error while creating employee");
			}
		}
		return null;
	}

	@Override
	@Transactional
	public EmployeeResponseDTO updateEmployee(EmployeeRequestDTO requestDTO, Long id) {

		if (requestDTO != null && id != null) {
			try {
				Optional<Employee> optional = employeeRepository.findById(id);
				if (optional.isPresent()) {
					Employee employee = optional.get();
					BeanUtils.copyProperties(requestDTO, employee, "department", "reportingManager");

					employeeRepository.save(employee);

					EmployeeResponseDTO response = getResponse(employee);

					return response;
				}

			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException("Error while updating employee");
			}
		}
		return null;
	}

	public EmployeeResponseDTO getResponse(Employee employee) {
		if (employee != null) {
			try {
				EmployeeResponseDTO response = new EmployeeResponseDTO();
				BeanUtils.copyProperties(employee, response, "department", "reportingManager");
				if (employee.getDepartment() != null && employee.getDepartment().getDepartmentName() != null) {
					response.setDepartment(employee.getDepartment().getDepartmentName());
				} else if (employee.getDepartment() != null) {
					response.setDepartment(employee.getDepartment().getId().toString());
				}
				if (employee.getReportingManager() != null && employee.getReportingManager().getName() != null) {
					response.setReportingManager(employee.getReportingManager().getName());
				} else if (employee.getReportingManager() != null) {
					response.setReportingManager(employee.getReportingManager().getId().toString());
				}
				return response;

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;

	}

	@Override
	public EmployeeResponseDTO updateEmployeeDepartment(Long id, Long departmentId) {
		if (id != null && departmentId != null) {
			try {
				Optional<Employee> optional = employeeRepository.findById(id);
				if (optional.isPresent()) {
					Employee employee = optional.get();
					if (!employee.getDepartment().getId().equals(departmentId)) {
						employee.setDepartment(new Department());
						employee.getDepartment().setId(departmentId);
						employeeRepository.save(employee);

						EmployeeResponseDTO response = getResponse(employee);
						return response;
					}
				}
			}catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException("Error while updating employee department details");
			}
			
		}
		return null;
	}

	@Override
	public Map<String, Object> getAllEmployees(int page, int size) {
		try {
			Pageable pageable = PageRequest.of(page, size);
			Page<EmployeeDTO> employee = employeeRepository.findAllDetails(pageable);

			Map<String, Object> response = new HashMap<>();
			response.put("employees", employee.getContent());
			response.put("currentPage", employee.getNumber());
			response.put("totalPages", employee.getTotalPages());
			response.put("totalItems", employee.getTotalElements());
			return response;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Error while fetching employee details");
		}
	}

	@Override
	public Map<String, Object> getAllEmployeeIds(int page, int size, String lookup) {
		if (lookup != null && lookup.equals("true")) {
			try {
				List<EmployeeDetailsDTO> dtos = new ArrayList<>();
				Pageable pageable = PageRequest.of(page, size);
				Page<Employee> employee = employeeRepository.findAll(pageable);
				if (!employee.isEmpty()) {
					for (Employee data : employee.getContent()) {
						EmployeeDetailsDTO dto = new EmployeeDetailsDTO();
						dto.setName(data.getName());
						dto.setId(data.getId());
						dtos.add(dto);
					}
					Map<String, Object> response = new HashMap<>();
					response.put("employees", dtos);
					response.put("currentPage", employee.getNumber());
					response.put("totalPages", employee.getTotalPages());
					response.put("totalItems", employee.getTotalElements());

					return response;
				}

			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException("Error while fetching employee details");
			}
		}
		return null;
	}

}
