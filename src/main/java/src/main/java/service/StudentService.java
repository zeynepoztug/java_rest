package src.main.java.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import src.main.java.model.Student;

@Service("studentService")
public class StudentService {
	
	private Long id = 0L;
	
	@Autowired
	StringGeneratorService stringService;
	
	public StudentService() {
		
	}
	
	public Student getRandomStudent() {
		Student student = new Student();
		student.setId(this.id);
		student.setName(stringService.generateRandomAlphaString());
		student.setPassportNumber(stringService.generateRandomAlphaNumericString());
		this.id ++;
		return student;
	}
	
	

}
