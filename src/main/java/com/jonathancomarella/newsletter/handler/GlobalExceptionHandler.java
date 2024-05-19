package com.jonathancomarella.newsletter.handler;

import com.jonathancomarella.newsletter.exception.EmailAlreadyExistsException;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EmailAlreadyExistsException.class)
    public ResponseEntity<ErrorDetails> handleEmailAlreadyExistsException(EmailAlreadyExistsException ex) {
        ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage());
        return new ResponseEntity<>(errorDetails, HttpStatus.CONFLICT);
    }

    @Data
    public static class ErrorDetails {
        private Date timestamp;
        private String message;

        public ErrorDetails(Date timestamp, String message) {
            this.timestamp = timestamp;
            this.message = message;
        }
    }
}
