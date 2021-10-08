package it.alessiomaddaluno.anagrafica.exception;



import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;


public class GenericErrorResponse {

    private String message;
    private LocalDateTime timeStamp;
    private HttpStatus status;

    public GenericErrorResponse(String message, LocalDateTime timeStamp, HttpStatus status) {
        this.message = message;
        this.timeStamp = timeStamp;
        this.status = status;
    }

    public GenericErrorResponse(String message, HttpStatus status) {
        this.message = message;
        this.status = status;
    }

    public GenericErrorResponse() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }
}
