package src.main.java.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import src.main.java.model.Student;
import src.main.java.repository.StudentJdbcRepository;
import src.main.java.service.StudentRepoService;

@RestController
public class StudentController {
	
	private static final Logger log = LoggerFactory.getLogger(StudentController.class);
	
	@Autowired
    StudentRepoService service;
	
	@GetMapping("/getAllStudents")
    public List<Student> getAllStudents() {
		log.info("getAllStudents request...");
		return service.getAllStudents();
    }
	
	@GetMapping("/getLastStudents")
    public List<Student> getLastStudents() {
		log.info("getLastStudents request...");
		return service.getLastStudents();
    }

}
