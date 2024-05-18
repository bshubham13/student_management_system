package com.qsp.student_management_system.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.qsp.student_management_system.dao.StudentDao;
import com.qsp.student_management_system.dto.Student;
import com.qsp.student_management_system.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {
	
	@Autowired 
	private StudentDao dao;
	@Autowired 
	private StudentService service;
	
	
	//****************************************   FOR SAVE  *************************************************************

	
	@PostMapping("/save")
	public Student saveStudent(@RequestBody Student student) {
		return service.saveStudent(student); 
	}
	
	@PostMapping("/saveall")
	public List<Student> saveStudents(@RequestBody List<Student> list) {
		return service.saveStudents(list);  
 
	} 
	
	@GetMapping("/login")
	public String loginStudent(@RequestParam String userName, @RequestParam String password) {
		  return service.getStudent(userName,password); 
		 	} 
	
	
	//****************************************   FOR UPDATE  *************************************************************
	
		 @PutMapping("/update")
		    public Student updateStudent(@RequestParam int id, @RequestBody Student student
		    		) {
		        return service.updateStudent(id, student);
		    } 
		 
		 @PutMapping("/update/phone")
		    public Student updateStudentPhone(@RequestParam int id, @RequestParam long phone) {
		        return service.updateStudentPhone(id, phone);
		    }
		 
		 @PutMapping("/update/email")
		    public Student updateStudentEmail(@RequestParam int id, @RequestParam String email) {
		        return service.updateStudentEmail(id, email);
		    }
		 
		 
		 @PutMapping("/update/name")
		    public Student updateStudentName(@RequestParam int id, @RequestParam String name) {
		        return service.updateStudentName(id, name);
		    }
		 
		  @PutMapping("/update/password")
		    public Student updateStudentPassword(@RequestParam int id, @RequestParam String password) {
		        return service.updateStudentPassword(id, password);
		    }
		  
		  @PutMapping("/update/securedmarks")
		  public Student updatedSecuredMakrs(@RequestParam int id ,@RequestParam int securedMarks, Student student) {
			  return service.updateStudentSecuredMarks(id, securedMarks, student);
		  }
		   
		  
		//****************************************   FOR FETCH  *************************************************************

		  
		  @GetMapping("/fetch")
		    public Optional<Student> fetch(@RequestParam int id) { 
		        return service.findStudentById(id); 
		    }
		  
		  @GetMapping("/fetch/name") 
		    public List<Student> fetchByName(@RequestParam String name) {
		        return service.fetchByName(name);
		    }
		  
		  @GetMapping("/fetch/phone")
		    public Student fetchByPhone(@RequestParam long phone) {
		        return service.fetchByPhone(phone);
		    }
		  
		  @GetMapping("/fetch/mail")
		    public Student fetchByEmail(@RequestParam String email) {
		        return service.fetchByEmail(email);
		    }
		  
		  @GetMapping("/fetch/address")
		    public List<Student> fetchByAddress(@RequestParam String address) {
		        return service.fetchByAddress(address);
		    }
		  
		  @GetMapping("/fetch/grade")
		  public List<Student> fetchByGrade(@RequestParam String grade) {
			  return service.fetchByGrade(grade);
		  } 
		   
		  @GetMapping("/fetch/percentagelessthan")
		    public List<Student> fetchByPercentageLessThan(@RequestParam double percentage) {
		        return service.fetchByPercentageLessThan(percentage);
		    }
		  
		  @GetMapping("/fetch/percentagegreaterthan")
		    public List<Student> fetchByPercentageGreaterThan(@RequestParam double percentage) {
		        return service.fetchByPercentageGreaterThan(percentage);
		    }
		  
		  @GetMapping("/fetch/percentagebetween")
		    public List<Student> fetchByPercentageBetween(@RequestParam double percentage, @RequestParam double percentage2) {
		        return service.fetchByPercentageBetween(percentage, percentage2);
		    }
		  
		   
		  @GetMapping("/fetchall")
		    public List<Student> fetchAll() {
		        return service.fetchAll();
		    }
		  
		  
			//****************************************   FOR DELETE  *************************************************************
		  
		  
		  @DeleteMapping("/delete")
		    public String deleteStudentById(@RequestParam int id) {
		        return service.deleteStudentById(id);
		    }
		  
		  @DeleteMapping("/delete/phone")
		    public String deleteStudentByPhone(@RequestParam long phone) {
		        return service.deleteStudentByPhone(phone); 
		    }
		  
		  @DeleteMapping("/delete/email")
		    public String deleteStudentByEmail(@RequestParam String email) {
		        return service.deleteStudentByEmail(email);
		    }
		   
		  @DeleteMapping("/delete/name")
		    public String deleteStudentByName(@RequestParam String name) {
		        return service.deleteStudentByName(name);
		    }
		  
		  @DeleteMapping("/delete/address")
		    public String deleteStudentByAddress(@RequestParam String address) {
		        return service.deleteStudentByAddress(address); 
		    } 
		  
		  @DeleteMapping("/delete/grade")
		  public String deleteStudentByGrade(@RequestParam String grade) {
			  return service.deleteStudentByGrade(grade); 
		  }
	

}
