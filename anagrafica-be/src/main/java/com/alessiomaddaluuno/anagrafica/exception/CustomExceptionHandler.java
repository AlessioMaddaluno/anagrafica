package com.alessiomaddaluuno.anagrafica.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

@RestControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(value = {AnagraficaException.class})
    public ResponseEntity<?> genericHandler(AnagraficaException exception, HttpServletRequest request){

        GenericErrorResponse errorResponse = GenericErrorResponse
                .builder()
                .message(exception.getMessage())
                .status(exception.getStatus())
                .timeStamp(LocalDateTime.now()).build();

        return ResponseEntity.status(exception.getStatus()).body(errorResponse);
    }

}
