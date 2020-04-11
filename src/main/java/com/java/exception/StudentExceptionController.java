package com.java.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentExceptionController {
   @ExceptionHandler(value = RecordNotFoundException.class)
   public ResponseEntity<Object> exception(RecordNotFoundException exception) {
      return new ResponseEntity<>("Student not found", HttpStatus.NOT_FOUND);
   }
}
