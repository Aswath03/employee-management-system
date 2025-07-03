package com.demo.ems.entity;

import java.util.Date;

import org.hibernate.annotations.DynamicUpdate;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(schema = "ems", catalog = "ems", name = "employee")
@Data
@DynamicUpdate
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="id")
	private Long id ;
	
	@Column(name ="name")
	private String name;
	
	@Column(name ="dob")
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date dateOfBirth;
	
	@Column(name ="salary")
	private double salary;
	
	@Column(name ="address")
	private String address;
	
	@Column(name ="role")
	private String role;
	
	@Column(name ="joining_date")
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date joiningDate;
	
	@Column(name="bonus_percentage")
	private double bonusPercentage;
	
	@ManyToOne
	@JoinColumn(name="department_id")
	private Department department; 
	
	@ManyToOne
	@JoinColumn(name="reporting_manager_id")
	private Employee reportingManager;

}
