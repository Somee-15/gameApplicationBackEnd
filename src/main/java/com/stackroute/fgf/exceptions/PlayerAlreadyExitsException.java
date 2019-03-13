package com.stackroute.fgf.exceptions;

/*custom exception class when player already exits*/
public class PlayerAlreadyExitsException extends Exception {
    private String message;

    public PlayerAlreadyExitsException() {
    }

    public PlayerAlreadyExitsException(String message) {
        super(message);
        this.message = message;
    }
}
