package com.qsp.student_management_system.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.qsp.student_management_system.dto.Student;

public interface StudentRepo extends JpaRepository<Student, Integer>{
	
	Student findByPhone(long phone);
	Student getByEmail(String email);
	
	@Query("SELECT s FROM Student s WHERE s.name = ?1")
    List<Student> findByName(String name);
	
	@Query("SELECT s FROM Student s WHERE s.email = ?1")
    Student findByEmail(String email);
	
	@Query("SELECT s FROM Student s WHERE s.address = ?1")
    List<Student> findByAddress(String address);
	
	@Query("SELECT s FROM Student s WHERE s.grade = ?1")
    List<Student> findByGrade(String grade); 
	
	
	public List<Student> findByPercentageLessThan(double percentage); 
	public List<Student> findByPercentageGreaterThan(double percentage);
	public List<Student> findByPercentageBetween(double percentage, double percentage2);
	
}