package com.example.demo.controller;

import com.example.demo.exception.MyException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Map<String,String>> runtimeExceptionHandler(RuntimeException ex){
        log.error("Runtime Exception ", ex);
        return new ResponseEntity<>(Map.of("Exception","Runtime Exception"), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(MyException.class)
    public ResponseEntity<Map<String,String>> myCustomException(MyException ex){
        log.error("Exception Occured",ex);
        return new ResponseEntity<>(Map.of("Exception",ex.getMessage()), HttpStatus.GONE);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String,String>> univeralException(Exception ex){
        log.error("Exception Occured",ex);
        return new ResponseEntity<>(Map.of("Exception",ex.getMessage()), HttpStatus.GONE);
    }
}
