package ru.bmstu.icsnetwork.presentation.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class RestExceptionHandler {
    
    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<Object> handleAnyException(Exception e, WebRequest webRequest) {
        Map<String, Object> errorDetails = new HashMap<>();
        errorDetails.put("timestamp", new Date());
        errorDetails.put("message", e.getMessage());

        return new ResponseEntity<>(errorDetails, HttpStatus.I_AM_A_TEAPOT);
    }
}
