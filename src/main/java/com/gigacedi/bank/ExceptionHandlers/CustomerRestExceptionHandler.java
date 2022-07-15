package com.gigacedi.bank.ExceptionHandlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomerRestExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<CustomerErrorResponse> handleException (CustomerAllException exc) {

        CustomerErrorResponse customerErrorResponse = new CustomerErrorResponse(HttpStatus.NOT_FOUND.value(),
                exc.getMessage(), System.currentTimeMillis() );

        return new ResponseEntity<>(customerErrorResponse,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<CustomerErrorResponse> handleException (CustomerAlreadyExistException exc) {
        CustomerErrorResponse customerErrorResponse = new CustomerErrorResponse(HttpStatus.ALREADY_REPORTED.value(),
                exc.getMessage(),System.currentTimeMillis());
        return new ResponseEntity<>(customerErrorResponse,HttpStatus.ALREADY_REPORTED);
    }

    @ExceptionHandler
    public ResponseEntity<CustomerErrorResponse> handleException (Exception exc) {

        CustomerErrorResponse customerErrorResponse = new CustomerErrorResponse(HttpStatus.BAD_REQUEST.value(),
                exc.getMessage(), System.currentTimeMillis() );

        return new ResponseEntity<>(customerErrorResponse,HttpStatus.BAD_REQUEST);
    }

}
