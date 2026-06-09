package com.example.student_management.exception;

import com.example.student_management.dto.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<ErrorResponse> handlerStudentNotFoundException(
            StudentNotFoundException ex
    ){
      ErrorResponse error= new ErrorResponse(
              ex.getMessage(),
              HttpStatus.NOT_FOUND.value()
      );
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND.value())
                .body(error);
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> hanlerMethodArgumentNotValidException(
            MethodArgumentNotValidException ex
    ){
        String message=ex.getBindingResult()
                .getFieldError()
                .getDefaultMessage();
        ErrorResponse error = new ErrorResponse(
                message,
                HttpStatus.BAD_REQUEST.value()
        );
        return ResponseEntity
                .badRequest()
                .body(error);
    }
}

