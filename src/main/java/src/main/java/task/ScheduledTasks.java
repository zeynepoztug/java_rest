package src.main.java.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import src.main.java.model.Student;
import src.main.java.repository.StudentJdbcRepository;
import src.main.java.service.StringGeneratorService;

@Component
public class ScheduledTasks {
	
	private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

	RestTemplate restTemplate;
	
	StudentJdbcRepository repository;
	
	StringGeneratorService stringService;
	
	@Autowired
	public ScheduledTasks(StudentJdbcRepository repository, StringGeneratorService stringService) {
		restTemplate = new RestTemplate();
		this.repository = repository;
		this.stringService = stringService;
	}

	@Scheduled(fixedRate = 5000)
	public void getStudentInfo() {
	    Student response = restTemplate.getForObject("http://localhost:8080/studentGenerator", Student.class);
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
