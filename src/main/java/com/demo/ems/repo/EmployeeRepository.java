package com.demo.ems.repo;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.demo.ems.dto.EmployeeDTO;
import com.demo.ems.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	List<Employee> findByDepartmentId(Long id);

	@Query(value = "select e.id as id, e.name as name, e.dob as dob, e.salary as salary, e.address as address, e.role as role, e.joining_date as joiningDate, "
			+ " e.bonus_percentage as bonusPercentage, b.department_name as department, c.name as reportingManager from ems.employee as e join "
			+ "ems.department as b on e.department_id = b.id left join ems.employee as c on e.reporting_manager_id = c.id  order by e.id asc", nativeQuery = true)
	Page<EmployeeDTO> findAllDetails(Pageable pageable);

}
