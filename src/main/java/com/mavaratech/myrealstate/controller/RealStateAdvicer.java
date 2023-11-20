package com.mavaratech.myrealstate.controller;

import com.mavaratech.myrealstate.exceptions.InvalidTokenException;
import com.mavaratech.myrealstate.model.response.BadRequestResponse;
import com.mavaratech.myrealstate.model.response.BaseResponseRealEstates;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

import static com.mavaratech.myrealstate.config.RealEstateConstants.*;

@RestControllerAdvice
public class RealStateAdvicer{



    @ExceptionHandler(InvalidTokenException.class)
    public ResponseEntity<BadRequestResponse> handleConflict(RuntimeException ex, WebRequest request) {
        BadRequestResponse unAuthorized = new BadRequestResponse();
        unAuthorized.setResultCode(UNAUTHORIZED);
        unAuthorized.setResultDescription(ex.getMessage());
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(unAuthorized);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<BaseResponseRealEstates> handleValidationExceptions(MethodArgumentNotValidException ex) {
        BadRequestResponse badRequestResponse = new BadRequestResponse();
        badRequestResponse.setResultCode(BAD_REQUEST);
        badRequestResponse.setResultDescription(INVALID_INPUTS);
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            badRequestResponse.getErrors().put(fieldName, errorMessage);
        });
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(badRequestResponse);
    }
}
