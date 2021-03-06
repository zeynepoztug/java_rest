package com.java.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.java.exception.RecordNotFoundException;
import com.java.model.Student;
import com.java.service.StudentRepoService;

@RestController
public class StudentController {
	
	private static final Logger log = LoggerFactory.getLogger(StudentController.class);
	
    StudentRepoService service;
	
    @Autowired
    public StudentController(StudentRepoService service) {
        this.service = service;
    }
	
	@GetMapping("/students")
    public List<Student> students() {
		log.info("students request...");
		return service.getAllStudents();
    }
	
	@GetMapping("/last-students")
    public List<Student> lastStudents() {
		log.info("lastStudents request...");
		return service.getLastStudents();
    }
	
	@GetMapping("/students/{id}")
    public ResponseEntity<Student> one(@PathVariable Long id) {
		log.info("get student by id request...");
		Student student = service.findById(id);
		if(student == null) {
	         throw new RecordNotFoundException();
	    }
		return new ResponseEntity<Student>(student, HttpStatus.OK);
		
    }

}
