package com.qsp.student_management_system.dto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="student_info")
public class Student { 
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name="StudentId")
	private int id;
	@Column(name="StudentName")
	private String name;
	@Column(name="FatherName")
	private String fatherName;
	@Column(name="MotherName")
	private String motherName;
	@Column(name="StudentPhone",unique=true)
	private long phone;
	@Column(name="StudentAddress")
	private String address;
	@Column(name="StudentEmail",unique=true)
	private String email;
	@Column(name="StudentPassword")
	private String password;
	private int securedMarks;
	private int totalMarks;
	private double percentage;
	private String grade; 
	

}
