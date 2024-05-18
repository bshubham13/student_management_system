package com.qsp.student_management_system.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qsp.student_management_system.dao.StudentDao;
import com.qsp.student_management_system.dto.Student;
@Service 
public class StudentService {
	@Autowired 
	private StudentDao dao;
	
	
	//*******************************************   FOR SAVE  *******************************************************************
	
public Student saveStudent(Student student) {
	double totalMarks=student.getTotalMarks();
	double securedMarks=student.getSecuredMarks();
	if(securedMarks<=totalMarks) {
		double percentage= (securedMarks/totalMarks)*100; 
		student.setPercentage(percentage);		
		if(percentage>85) {
			student.setGrade("Distinction");
		} else if (percentage>=70&& percentage<85) {
			student.setGrade("First Class");
		} else if (percentage>=49&& percentage<70) {
			student.setGrade("First Class");
		} else if (percentage>=35&& percentage<49) {
			student.setGrade("Pass");
		} else {
			student.setGrade("Fail");
		}
	}
		
		return dao.saveStudent(student); 
	}


public List<Student> saveStudents( List<Student> list) {
	
	
	for(Student student:list) {
		double totalMarks=student.getTotalMarks();
	double securedMarks=student.getSecuredMarks();
	if(securedMarks<=totalMarks) {
		double percentage= (securedMarks/totalMarks)*100; 
		student.setPercentage(percentage);		
		if(percentage>85) {
			student.setGrade("Distinction");
		} else if (percentage>=70&& percentage<85) {
			student.setGrade("First Class");
		} else if (percentage>=49&& percentage<70) {
			student.setGrade("First Class");
		} else if (percentage>=35&& percentage<49) {
			student.setGrade("Pass");
		} else {
			student.setGrade("Fail");
		}
	}
	}
	
	
	return dao.saveStudents(list);

}


//****************************************   FOR LOGIN  *************************************************************


	public String getStudent(String userName,String password) {
		 return dao.getStudent(userName,password); 
	} 
	
	
//****************************************   FOR UPDATE  *************************************************************

	
    public Student updateStudent( int id,  Student student) {
        return dao.updateStudent(id, student);
    } 
    
    public Student updateStudentPhone( int id,  long phone) {
        return dao.updateStudentPhone(id, phone);
    }
    
    public Student updateStudentEmail( int id,  String email) {
        return dao.updateStudentEmail(id, email);
    }
 
   
 
    public Student updateStudentName( int id,  String name) {
        return dao.updateStudentName(id, name);
    }
 
    public Student updateStudentPassword( int id,  String password) {
        return dao.updateStudentPassword(id, password); 
    }
    
    public Student updateStudentSecuredMarks(int id, int securedMarks, Student student) {
    	 
    	
    	double totalMarks=student.getTotalMarks();
    	double securedMarks1=student.getSecuredMarks();
    	if(securedMarks1<=totalMarks) {
    		double percentage= (securedMarks1/totalMarks)*100; 
    		student.setPercentage(percentage);		
    		if(percentage>85) { 
    			student.setGrade("Distinction");
    		} else if (percentage>=70&& percentage<85) {
    			student.setGrade("First Class");
    		} else if (percentage>=49&& percentage<70) {
    			student.setGrade("First Class");
    		} else if (percentage>=35&& percentage<49) {
    			student.setGrade("Pass");
    		} else {
    			student.setGrade("Fail");
    		}
    	}
    	return dao.updateStudentSecuredMarks(id, (int) securedMarks1,student);  
    }
    
//****************************************   FOR FETCH  *************************************************************

    
    
    
    public Optional<Student> findStudentById( int id) {
        return dao.findStudentById(id);  
    }
  
    public List<Student> fetchByName( String name) {
        return dao.findStudentByName(name);
    }
  
    public Student fetchByPhone( long phone) {
        return dao.findStudentByPhone(phone);
    }
  
    public Student fetchByEmail( String email) {
        return dao.findStudentByEmail(email);
    }
  
    public List<Student> fetchByAddress( String address) {
        return dao.findStudentByAddress(address);
    }
    
    public List<Student> fetchByGrade(String grade) {
    	return dao.findStudentByGrade(grade); 
    }
    
    public List<Student> fetchByPercentageLessThan( double percentage) {
        return dao.findStudentWithPercentageLessThan(percentage);
    }
  
    public List<Student> fetchByPercentageGreaterThan( double percentage) {
        return dao.findStudentWithPercentageGreaterThan(percentage);
    }
  
    public List<Student> fetchByPercentageBetween( double percentage,  double percentage2) {
        return dao.findStudentWithPercentageBetween(percentage, percentage2);
    }
   
    
    public List<Student> fetchAll() {
        return dao.findAllStudent();
    }
    
    

	//****************************************   FOR DELETE  *************************************************************

    
  
    public String deleteStudentById( int id) {
        return dao.deleteStudentById(id);
    }
   
    public String deleteStudentByPhone( long phone) {
        return dao.deleteStudentByPhone(phone); 
    }
  
    public String deleteStudentByEmail( String email) {
        return dao.deleteStudentByEmail(email);
    }
   
    public String deleteStudentByName( String name) {
        return dao.deleteStudentByName(name);
    }
  
    public String deleteStudentByAddress( String address) {
        return dao.deleteStudentByAddress(address); 
    }
    
    public String deleteStudentByGrade(String grade) {
    	return dao.deleteStudentByGrade(grade); 
    }
 
	

}


