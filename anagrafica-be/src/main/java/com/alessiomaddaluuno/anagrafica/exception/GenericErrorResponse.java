package com.alessiomaddaluuno.anagrafica.exception;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Builder @Getter @Setter
public class GenericErrorResponse {

    private String message;
    private LocalDateTime timeStamp;
    private HttpStatus status;

}
