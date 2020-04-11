package com.java.service;

import java.util.Random;

import org.springframework.stereotype.Service;

@Service("stringGeneratorService")
public class StringGeneratorService {
	
	Random random = new Random();
	
	/* This method creates random alphanumeric string range A-Z0-9*/
	public String generateRandomAlphaNumericString() {
		int leftLimit = 48;
	    int rightLimit = 122;
	    int targetStringLength = 10;
	 
	    String generatedString = random.ints(leftLimit, rightLimit + 1)
	      .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
	      .limit(targetStringLength)
	      .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
	      .toString();
	 
	    return generatedString;
	}
	
	/* This method creates alphabetic strings range A-Z */
	public String generateRandomAlphaString() {
		String candidateChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		int length = 10;
	    StringBuilder sb = new StringBuilder();
	    for (int i = 0; i < length; i++) {
	        sb.append(candidateChars.charAt(random.nextInt(candidateChars
	                .length())));
	    }

	    return sb.toString();
	}
	
	/* This method takes a string as an argument and converts is to the title case e.g the title -> The Title */
	public String convertToTitleCaseIteratingChars(String text) {
	    if (text == null || text.isEmpty()) {
	        return text;
	    }
	 
	    StringBuilder converted = new StringBuilder();
	 
	    boolean convertNext = true;
	    for (char ch : text.toCharArray()) {
	        if (Character.isSpaceChar(ch)) {
	            convertNext = true;
	        } else if (convertNext) {
	            ch = Character.toTitleCase(ch);
	            convertNext = false;
	        } else {
	            ch = Character.toLowerCase(ch);
	        }
	        converted.append(ch);
	    }
	 
	    return converted.toString();
	}

}
