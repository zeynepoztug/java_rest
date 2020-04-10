package src.main.java.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import src.main.java.model.Student;
import src.main.java.repository.StudentJdbcRepository;

@Service("studentRepoService")
public class StudentRepoServiceImpl implements StudentRepoService{
	
	StudentJdbcRepository repository;
	
    @Autowired
    public StudentRepoServiceImpl(StudentJdbcRepository repository) {
        this.repository = repository;
    }

	@Override
	public List<Student> getAllStudents() {
		return repository.findAll();
	}

	@Override
	public List<Student> getLastStudents() {
		return repository.findLastStudents();
	}

	@Override
	public Student findById(Long id) {
		return repository.findById(id);
	}

}
