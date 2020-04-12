package com.java.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.DEFINED_PORT)
public class StringGeneratorServiceTest {
	
    @Autowired
    private StringGeneratorService stringService;
    
    @Test
    public void testTitleCase() throws Exception {
	   assertThat(stringService.convertToTitleCaseIteratingChars("title")).isEqualTo("Title");
	   assertThat(stringService.convertToTitleCaseIteratingChars("tITLE")).isEqualTo("Title");
	   assertThat(stringService.convertToTitleCaseIteratingChars("TiTlE")).isEqualTo("Title");
	   assertThat(stringService.convertToTitleCaseIteratingChars("TITLE")).isEqualTo("Title");
	   assertThat(stringService.convertToTitleCaseIteratingChars("Title")).isEqualTo("Title");
   }
    
    @Test
    public void testRandomAplhaString() throws Exception {
	   assertThat(stringService.generateRandomAlphaString()).isInstanceOf(String.class);
   }
    
    @Test
    public void testRandomAplhaNumericString() throws Exception {
	   assertThat(stringService.generateRandomAlphaNumericString()).isInstanceOf(String.class);
   }

}
