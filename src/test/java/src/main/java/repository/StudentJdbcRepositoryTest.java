package src.main.java.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import src.main.java.model.Student;
import src.main.java.repository.StudentJdbcRepository;

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
        alice.setId(12L);
        alice.setName("Alice");
        alice.setPassportNumber("1234CDS");
        
        bob = new Student();
        bob.setId(13L);
        bob.setName("Bob");
        bob.setPassportNumber("857567yhj");
    }
	
	@Test
    public void createTest() {
		repository.insert(alice);

        Student validStudent = repository.findById(alice.getId());

        assertThat(validStudent.getId()).isEqualTo(alice.getId());
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
