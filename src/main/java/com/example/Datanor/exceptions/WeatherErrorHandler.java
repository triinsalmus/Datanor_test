package com.example.Datanor.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class WeatherErrorHandler {

    @ExceptionHandler(WeatherException.class)
    public ResponseEntity<Object> handleError400(WeatherException exception) {
        return new ResponseEntity<Object>(new WeatherErrorResponse(exception.getMessage(), 400),
                HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleError500(Exception exception) {
        exception.printStackTrace();
        return new ResponseEntity<Object>(new WeatherErrorResponse(exception.getMessage(), 500),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
