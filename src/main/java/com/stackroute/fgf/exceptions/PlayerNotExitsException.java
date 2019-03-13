package com.stackroute.fgf.exceptions;

/*custom exception class when player not exits*/
public class PlayerNotExitsException extends Exception {
    private String message;

    public PlayerNotExitsException() {
    }

    public PlayerNotExitsException(String message) {
        super(message);
        this.message = message;
    }
}
