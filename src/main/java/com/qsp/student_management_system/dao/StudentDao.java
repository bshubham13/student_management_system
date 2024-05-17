package com.qsp.student_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;
import com.qsp.student_management_system.dto.Student;
import com.qsp.student_management_system.repo.StudentRepo;

@Repository 
public class StudentDao {
	@Autowired 
	private StudentRepo repo;
	
	//****************************************   FOR SAVE  *************************************************************

	public Student saveStudent(Student student) {
		return repo.save(student);
 
	}
	

	public List<Student> saveStudents(@RequestBody List<Student> list) {
		return repo.saveAll(list); 
	}
	
	//****************************************   FOR LOGIN  *************************************************************

		public Student findStudent(long phone) {
			return repo.findByPhone(phone);
		}

		public Student findStudent(String email) {
			return repo.getByEmail(email);
		}

		public String getStudent(String userName, String password) {
			try {
				long phone = Long.parseLong(userName);
			 	Student student= findStudent(phone);
				if (student != null) {
					if (password.equals(student.getPassword())) {
						return "Login Success";
					} else {
						return "invalid password";
					}
				} else {
					return "Student not found"; 
				}
				
				 
			} catch (Exception e) {
				String email = userName;
				Student student=findStudent(email);
				if (student != null) {
					if (password.equals(student.getPassword())) {
						return "Login Success";
					} else {
						return "invalid password";
					}
				} else {
					return "Student not found"; 
				}
				
			}
		}
		
		
		//****************************************   FOR UPDATE  *************************************************************


		public Student updateEmployee(int id, Student updatedStudent) {
	        Optional<Student> optional = repo.findById(id);
	        if (optional.isPresent()) { 
	            updatedStudent.setId(id);
	            return repo.save(updatedStudent);
	        } else { 
	            return null; // Or you can throw an exception indicating that the employee with the given ID was not found
	        }
	    }
		
		public Student updateStudentPhone(int id, long phone) {
	        Optional<Student> optional = repo.findById(id);
	        if (optional.isPresent()) {
	            Student student = optional.get();
	            student.setPhone(phone);
	            return repo.save(student); 
	        } else { 
	            return null; 
	        }
	    }
		
		
		public Student updateStudentEmail(int id, String email) {
	        Optional<Student> optional = repo.findById(id);
	        if (optional.isPresent()) {
	            Student student = optional.get();
	            student.setEmail(email);
	            return repo.save(student);
	        } else {
	            return null; 
	        }
	    }
		
		 
		 
		 public Student updateStudentName(int id, String name) {
		        Optional<Student> optional = repo.findById(id);
		        if (optional.isPresent()) {
		            Student student = optional.get();
		            student.setName(name);
		            return repo.save(student);
		        } else {
		            return null;  
		        }
		    }
		 
		 public Student updateStudentPassword(int id, String password) {
		        Optional<Student> optional = repo.findById(id);
		        if (optional.isPresent()) {
		            Student student = optional.get();
		            student.setPassword(password);
		            return repo.save(student);
		        } else {
		            return null;  
		        }
		    }
		 
		 
		 
			//****************************************   FOR FETCH  *************************************************************

		 
		 
		 public Optional<Student> findStudentById(int id) {
		        return repo.findById(id);
		    }
		  
		 public List<Student> findStudentByName(String name) {
		        return repo.findByName(name);
		    }
		 	 
		 public Student findStudentByPhone(long phone) {
		        return repo.findByPhone(phone);
		    }
		 
		 public Student findStudentByEmail(String email) {
		        return repo.findByEmail(email);
		    }
		 
		 public List<Student> findStudentByAddress(String address) {
		        return repo.findByAddress(address);
		    }
		 
		 public List<Student> findStudentByGrade(String grade) {
			 return repo.findByGrade(grade); 
		 }
		 
		 public List<Student> findStudentWithPercentageLessThan(double percentage) {
		        return repo.findByPercentageLessThan(percentage);
		    }
		 
		 public List<Student> findStudentWithPercentageGreaterThan(double percentage) {
		        return repo.findByPercentageGreaterThan(percentage);
		    }
		 
		 public List<Student> findStudentWithPercentageBetween(double percentage, double percentage2) {
		        return repo.findByPercentageBetween(percentage, percentage2);
		    } 
		 
		 
		 public List<Student> findAllStudent() {
		        return repo.findAll();
		    }
		 
			//****************************************   FOR DELETE  *************************************************************

		 
		 public String deleteStudentById(int id) {
		        Optional<Student> optionalStudent = repo.findById(id);
		        if (optionalStudent.isPresent()) {
		            repo.delete(optionalStudent.get());
		            return "Deleted Successfully";
		        } else {
		            return "Student with id " + id + " not found";
		        }
		    }
		 
		 public String deleteStudentByPhone(long phone) {
			 Student student = repo.findByPhone(phone);
		        if (student != null) {
		            repo.delete(student);
		            return "Deleted Successfully";
		        } else {
		            return "Student with phone number " + phone + " not found";
		        }
		    }
		 
		 public String deleteStudentByEmail(String email) {
			 Student student = repo.getByEmail(email);
		        if (student != null) {
		            repo.delete(student);
		            return "Deleted Successfully";
		        } else {
		            return "Student with email " + email + " not found";
		        }
		    }
		 
		 public String deleteStudentByName(String name) {
		        List<Student> student = repo.findByName(name);
		        if (!student.isEmpty()) {
		            repo.deleteAll(student);
		            return "Deleted Successfully";
		        } else {
		            return "Student with name " + name + " not found";
		        }
		    }
		 
		 
		 public String deleteStudentByAddress(String address) {
		        List<Student> student = repo.findByAddress(address);
		        if (!student.isEmpty()) {
		            repo.deleteAll(student);
		            return "Deleted Successfully";
		        } else {
		            return "Student with address " + address + " not found";
		        }
		    }
		 
		 public String deleteStudentByGrade(String grade) {
			 List<Student> student = repo.findByGrade(grade);
			 if(!student.isEmpty()) {
				 repo.deleteAll();
				 return "Deleted Sccessfully";
			 } else {
				 return "Student with grade " + grade + " not found";
			 }
		 }
		
		 
		
		 
		 
		
 
}
