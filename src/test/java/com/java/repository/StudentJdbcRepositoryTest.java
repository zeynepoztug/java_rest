package com.java.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import com.java.model.Student;
import com.java.repository.StudentJdbcRepository;

@RunWith(SpringRunner.class)
@JdbcTest
@ComponentScan
public class StudentJdbcRepositoryTest {
	
	@Autowired
	StudentJdbcRepository repository;
	
	private Student alice;
	private Student bob;
	
	@Before
    public void setUp(){
        alice = new Student();
        alice.setName("Alice");
        alice.setPassportNumber("1234CDS");
        
        bob = new Student();
        bob.setName("Bob");
        bob.setPassportNumber("857567yhj");
    }
	
	@Test
    public void createTest() {
		int generatedId = repository.insert(alice);

        Student validStudent = repository.findById(generatedId);

        assertThat(validStudent.getId()).isEqualTo(generatedId);
        assertThat(validStudent.getName()).isEqualTo(alice.getName());
        assertThat(validStudent.getPassportNumber()).isEqualTo(alice.getPassportNumber());
    }
	
	@Test
    public void findAll_forEmptyDatabase() {
        List<Student> noCustomers = repository.findAll();
        assertThat(noCustomers).isNullOrEmpty();
    }
	
	@Test
    public void findAllSizeCheck() {

        repository.insert(alice);
        List<Student> students = repository.findAll();

        assertThat(students).isNotNull().hasSize(1);

        repository.insert(bob);
        students = repository.findAll();

        assertThat(students).isNotNull().hasSize(2);
    }

}
