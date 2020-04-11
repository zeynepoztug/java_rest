package com.java.service;

import java.util.List;

import com.java.model.Student;

public interface StudentRepoService {
	
	public List<Student> getAllStudents();
	
	public List<Student> getLastStudents();
	
	public Student findById(Long id);

}