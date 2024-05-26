package com.openpay.marvelapi.consumer.exception;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = {ConstraintViolationException.class})
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ValidationError constraintViolationException(ConstraintViolationException ex) {
        ValidationError errors = new ValidationError();
        for (ConstraintViolation violation : ex.getConstraintViolations()) {
            errors.addViolations(new ErrorDetails(violation.getMessage(), violation.getPropertyPath().toString()));
        }
        return errors;
    }

    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ValidationError constraintViolationException(MethodArgumentNotValidException ex) {
        ValidationError errors = new ValidationError();
        for (FieldError violation : ex.getBindingResult().getFieldErrors()) {
            errors.addViolations(new ErrorDetails(violation.getDefaultMessage(), violation.getField()));
        }
        return errors;
    }
}
