package com.alessiomaddaluuno.anagrafica.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(value = {AnagraficaException.class})
    public ResponseEntity<GenericErrorResponse> genericHandler(AnagraficaException exception, HttpServletRequest request){

        GenericErrorResponse errorResponse = new GenericErrorResponse(exception.getMessage(),exception.getStatus());

        return ResponseEntity.status(exception.getStatus()).body(errorResponse);
    }

}
