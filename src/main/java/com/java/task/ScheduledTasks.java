package com.java.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.java.model.Student;
import com.java.repository.StudentJdbcRepository;
import com.java.service.StringGeneratorService;

@Component
public class ScheduledTasks {
	
	private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

	RestTemplate restTemplate;
	
	StudentJdbcRepository repository;
	
	StringGeneratorService stringService;
	
	@Value("${students.get-url}")
    private String getUrl;
	
	@Autowired
	public ScheduledTasks(StudentJdbcRepository repository, StringGeneratorService stringService) {
		restTemplate = new RestTemplate();
		this.repository = repository;
		this.stringService = stringService;
	}

	@Scheduled(fixedRateString = "${fixedRate}")
	public void getStudentInfo() {
	    Student response = restTemplate.getForObject(getUrl, Student.class);
		log.info("Random student created...");
		modifyStudent(response);
		log.info("Random student modified...");
		insertStudent(response);
		log.info("Random student inserted...");
	}
	
	private void modifyStudent(Student student) {
		student.setName(stringService.convertToTitleCaseIteratingChars(student.getName()));
	}
	
	public void insertStudent(Student student) {
		repository.insert(student);
	}

}
