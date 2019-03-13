package com.stackroute.fgf.exceptions;

public class PlayerNotExitsException extends Exception {
    private String message;

    public PlayerNotExitsException() {
    }

    public PlayerNotExitsException(String message) {
        super(message);
        this.message = message;
    }
}
