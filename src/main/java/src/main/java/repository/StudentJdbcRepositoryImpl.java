package src.main.java.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import src.main.java.model.Student;

@Repository
public class StudentJdbcRepositoryImpl implements StudentJdbcRepository{
	
    JdbcTemplate jdbcTemplate;
	
    @Autowired
    public StudentJdbcRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    class StudentRowMapper implements RowMapper <Student> {

        @Override

        public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
            Student student = new Student();
            student.setId(rs.getLong("id"));
            student.setName(rs.getString("name"));
            student.setPassportNumber(rs.getString("passport_number"));
            return student;
        }

    }

    public List<Student> findAll() {
        return jdbcTemplate.query("select * from student", new StudentRowMapper());
    }
    
    public List<Student> findLastStudents() {
        return jdbcTemplate.query("select * from student order by id desc limit 10", new StudentRowMapper());
    }
    
    public int insert(Student student) {
        String sql = "insert into student (name, passport_number) values (?, ?)";
        return jdbcTemplate.update(sql, student.getName(), student.getPassportNumber());
    }
    
    public Student findById(long id) {
    	
    	String sql = "SELECT * FROM student WHERE id = ?";
		RowMapper<Student> rowMapper = new BeanPropertyRowMapper<Student>(Student.class);
		Student student;
		try {
			student = jdbcTemplate.queryForObject(sql, rowMapper, id);
		} catch (EmptyResultDataAccessException e) {
			student = null;
		}
		return student;

    }

}
