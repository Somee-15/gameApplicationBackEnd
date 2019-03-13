package com.stackroute.fgf.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/*class to handle all Exception*/
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(PlayerAlreadyExitsException.class)
    public ResponseEntity<String> handlePlayerAlreadyExitsException(PlayerAlreadyExitsException e) {
        return new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(PlayerNotExitsException.class)
    public ResponseEntity<String> handlePlayerNotExitsException(PlayerNotExitsException e) {
        return new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);

    }

}
