package src.main.java.repository;

import java.util.List;

import src.main.java.model.Student;

public interface StudentJdbcRepository {

    public List<Student> findAll();
    
    public List<Student> findLastStudents();
    
    public void insert(Student student);
    
    public Student findById(long id);

}
