package com.examly.springapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class SeatsExceededException extends RuntimeException{
    public SeatsExceededException(String message){
        super(message);
    }
}
