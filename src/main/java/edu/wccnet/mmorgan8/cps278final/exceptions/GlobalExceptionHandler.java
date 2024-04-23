package edu.wccnet.mmorgan8.cps278final.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<MovieErrorResponse> exceptionHandler(MovieNotFoundException ex){
        MovieErrorResponse error = new MovieErrorResponse();
        error.setMessage(ex.getMessage());
        error.setTimestamp(System.currentTimeMillis());
        error.setStatus(HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<UserErrorResponse> exceptionHandler(UserNotFoundException ex){
        UserErrorResponse error = new UserErrorResponse();
        error.setMessage(ex.getMessage());
        error.setTimestamp(System.currentTimeMillis());
        error.setStatus(HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<UserErrorResponse> exceptionHandler(Exception ex){
        UserErrorResponse error = new UserErrorResponse();
        error.setMessage(ex.getMessage());
        error.setTimestamp(System.currentTimeMillis());
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
