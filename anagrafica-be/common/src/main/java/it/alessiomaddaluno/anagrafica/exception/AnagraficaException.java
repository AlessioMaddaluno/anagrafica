package it.alessiomaddaluno.anagrafica.exception;

import org.springframework.http.HttpStatus;

public class AnagraficaException extends RuntimeException{

    private HttpStatus status;

    public AnagraficaException(String exMessage, Exception exception){
        super(exMessage,exception);
    }

    public AnagraficaException(String exMessage, HttpStatus status){
        super(exMessage);
        this.status = status;
    }

    public HttpStatus getStatus(){
        return this.status;
    }
}
