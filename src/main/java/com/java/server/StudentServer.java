package com.java.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.model.Student;
import com.java.service.StudentService;

@RestController
public class StudentServer {
	
	private static final Logger log = LoggerFactory.getLogger(StudentServer.class);
	
	StudentService service;
	
    @Autowired
    public StudentServer(StudentService service) {
        this.service = service;
    }
	
	@GetMapping("/studentGenerator")
	public Student studentGenerator() {
		log.info("studentGenerator request...");
		return service.getRandomStudent();
	}

}
