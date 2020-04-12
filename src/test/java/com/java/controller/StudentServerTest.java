package com.java.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.java.model.Student;
import com.java.server.StudentServer;
import com.java.service.StudentService;

@RunWith(SpringRunner.class)
@WebMvcTest(StudentServer.class)
public class StudentServerTest {

    @Autowired
    private MockMvc mockMvc;
    
    @MockBean
    private StudentService studentService;
    
    @Test
    public void testGenerateStudent() throws Exception {
	   Student student = new Student();
	   student.setName("name");
	   student.setPassportNumber("123XDE");
	   Mockito.when(studentService.getRandomStudent()).thenReturn(student);

	   mockMvc.perform(MockMvcRequestBuilders.get("/generate-student"))
	         .andExpect(MockMvcResultMatchers.status().isOk())
	         .andDo(print())
	         .andExpect(MockMvcResultMatchers.jsonPath("$.id").isEmpty())
	         .andExpect(MockMvcResultMatchers.jsonPath("$.name").isNotEmpty())
	         .andExpect(MockMvcResultMatchers.jsonPath("$.passportNumber").isNotEmpty());

   }
}