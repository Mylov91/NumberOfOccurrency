package ru.mylov.numberofoccurrences.exceptions;

import org.springframework.beans.factory.annotation.Autowired;

public class EmptyMessageException extends RuntimeException {
    private final String message;

    @Autowired
    public EmptyMessageException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
