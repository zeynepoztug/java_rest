package src.main.java.service;

import java.util.List;

import src.main.java.model.Student;

public interface StudentRepoService {
	
	public List<Student> getAllStudents();
	
	public List<Student> getLastStudents();
	
	public Student findById(Long id);

}
