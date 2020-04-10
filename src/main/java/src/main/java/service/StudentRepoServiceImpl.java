package src.main.java.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import src.main.java.model.Student;
import src.main.java.repository.StudentJdbcRepository;

@Service("studentRepoService")
public class StudentRepoServiceImpl implements StudentRepoService{
	
	@Autowired
	StudentJdbcRepository repository;

	@Override
	public List<Student> getAllStudents() {
		return repository.findAll();
	}

	@Override
	public List<Student> getLastStudents() {
		return repository.findLastStudents();
	}

}
