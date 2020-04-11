package com.java.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.model.Student;

@Service("studentService")
public class StudentService {
	
	StringGeneratorService stringService;
	
	@Autowired
    public StudentService(StringGeneratorService stringService) {
        this.stringService = stringService;
    }
	
	public Student getRandomStudent() {
		Student student = new Student();
		student.setName(stringService.generateRandomAlphaString());
		student.setPassportNumber(stringService.generateRandomAlphaNumericString());
		return student;
	}
	
	

}
