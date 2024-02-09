package ru.mylov.numberofoccurrences.exceptions;

import org.springframework.beans.factory.annotation.Autowired;

public class WrongMessageCharactersException extends RuntimeException {
    private final String message;

    @Autowired
    public WrongMessageCharactersException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
