package src.main.java.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import src.main.java.model.Student;

@Service("studentService")
public class StudentService {
	
	@Autowired
	StringGeneratorService stringService;
	
	public StudentService() {
		
	}
	
	public Student getRandomStudent() {
		Student student = new Student();
		student.setName(stringService.generateRandomAlphaString());
		student.setPassportNumber(stringService.generateRandomAlphaNumericString());
		return student;
	}
	
	

}
