package com.mavaratech.myrealstate.controller;

import com.mavaratech.myrealstate.exceptions.InvalidTokenException;
import com.mavaratech.myrealstate.model.response.BaseResponseRealEstates;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class RealStateAdvicer extends ResponseEntityExceptionHandler {

    @ExceptionHandler(InvalidTokenException.class)
    public ResponseEntity<RealStateAdvicer> handleConflict(RuntimeException ex, WebRequest request) {
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }
}
