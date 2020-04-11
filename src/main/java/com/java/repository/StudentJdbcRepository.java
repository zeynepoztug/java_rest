package com.java.repository;

import java.util.List;

import com.java.model.Student;

public interface StudentJdbcRepository {

    public List<Student> findAll();
    
    public List<Student> findLastStudents();
    
    public int insert(Student student);
    
    public Student findById(long id);

}
