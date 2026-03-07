/**
 * 
 */
package com.capgemini.assessment.Exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import jakarta.servlet.http.HttpServletRequest;

/**
 * 
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(PolicyNotFoundException.class)
    public ResponseEntity<?> handlePolicyNotFound(
            PolicyNotFoundException ex,
            HttpServletRequest request){

        Map<String,Object> error = new HashMap<>();

        error.put("timestamp", LocalDateTime.now());
        error.put("status",404);
        error.put("error",ex.getMessage());
        error.put("path",request.getRequestURI());

        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }
}