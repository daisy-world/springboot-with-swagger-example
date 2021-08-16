package com.app.easy2excel.exception;


import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler  {

    @ExceptionHandler(RecordNotFoundException.class)
    public ResponseEntity<ErrorResponse> recordNotFoundException(RecordNotFoundException exception) {
        ErrorResponse errorResponse = new ErrorResponse(exception.getMessage(), System.currentTimeMillis(), HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(EmailNotFoundException.class)
    public ResponseEntity<ErrorResponse> emailNotFoundException(EmailNotFoundException exception) {
        ErrorResponse errorResponse = new ErrorResponse(exception.getMessage(), System.currentTimeMillis(), HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> methodArgumentNotValidException(MethodArgumentNotValidException exception) {
        ErrorResponse errorResponse = new ErrorResponse( exception.getBindingResult().getFieldError().getDefaultMessage(), System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}
