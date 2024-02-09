package ru.mylov.numberofoccurrences.exceptions;

import org.springframework.beans.factory.annotation.Autowired;

public class WrongMessageLengthException extends RuntimeException {
    private final String message;

    @Autowired
    public WrongMessageLengthException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
