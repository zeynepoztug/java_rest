package src.main.java.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import src.main.java.model.Student;

@Repository
public class StudentJdbcRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;
    
    public void setDataSource(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
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
        return jdbcTemplate.update("insert into student (id, name, passport_number) " + "values(?,  ?, ?)",
            new Object[] {
                student.getId(), student.getName(), student.getPassportNumber()
            });
    }
    
    public Student findById(long id) {
        return jdbcTemplate.queryForObject("select * from student where id=?", new Object[] {
                id
            },
            new BeanPropertyRowMapper < Student > (Student.class));

    }

}
