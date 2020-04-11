package com.java.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.java.model.Student;

@Repository
public class StudentJdbcRepositoryImpl implements StudentJdbcRepository{
	
    JdbcTemplate jdbcTemplate;
	
    @Autowired
    public StudentJdbcRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Student> findAll() {
    	return jdbcTemplate.query(
                "select * from student",
                (rs, rowNum) ->
                        new Student(
                                rs.getLong("id"),
                                rs.getString("name"),
                                rs.getString("passport_number")
                        )
        );
    }
    
    public List<Student> findLastStudents() {
    	return jdbcTemplate.query(
                "select * from student order by modified desc limit 10",
                (rs, rowNum) ->
                        new Student(
                                rs.getLong("id"),
                                rs.getString("name"),
                                rs.getString("passport_number")
                        )
        );
    }
    
    public int insert(Student student) {
        String sql = "insert into student (name, passport_number) values (?, ?)";
        return jdbcTemplate.update(sql, student.getName(), student.getPassportNumber());
    }
    
    public Student findById(long id) {
    	Student student = null;
    	try {
    		student = jdbcTemplate.queryForObject(
                "select * from student where id = ?",
                new Object[]{id},
                (rs, rowNum) ->
                        new Student(
                                rs.getLong("id"),
                                rs.getString("name"),
                                rs.getString("passport_number")
                        )
    				); 
    	} catch (EmptyResultDataAccessException e) {
			student = null;
		}
    	return student;

    }

}
