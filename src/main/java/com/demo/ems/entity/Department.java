package com.demo.ems.entity;

import java.util.Date;
import java.util.List;

import org.hibernate.annotations.DynamicUpdate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(schema = "ems", catalog = "ems", name = "department")
@Data
@DynamicUpdate
public class Department {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="id")
	private Long id ;
	
	@Column(name ="department_name")
	private String departmentName;
	
	@ManyToOne
	@JoinColumn(name = "department_head_id")
	private Employee departmentHead;
	
	@Column(name = "created_on")
	private Date creationDate;
	
	@OneToMany(mappedBy = "department" , fetch = FetchType.LAZY)
	private List<Employee> employees ; 

}
