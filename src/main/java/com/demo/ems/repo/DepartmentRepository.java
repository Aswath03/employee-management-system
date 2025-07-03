package com.demo.ems.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.demo.ems.dto.DepartmentDTO;
import com.demo.ems.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

	@Query(value="select a.id as id, a.department_name as departmentName, b.name as departmentHead, a.created_on as "
			+ " creationDate from ems.department as a join ems.employee as b on a.department_head_id = b.id",nativeQuery = true)
	Page<DepartmentDTO> findAllDetails(Pageable pageable);

}
 