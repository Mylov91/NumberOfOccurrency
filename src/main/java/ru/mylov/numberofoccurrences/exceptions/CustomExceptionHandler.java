package ru.mylov.numberofoccurrences.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.mylov.numberofoccurrences.utils.ResponseMessage;

import java.time.LocalDateTime;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(value = EmptyMessageException.class)
    public ResponseEntity<Object> handleEmptyMessageException(EmptyMessageException e) {
        ResponseMessage responseMessage = new ResponseMessage(e.getMessage(), LocalDateTime.now());
        return new ResponseEntity<>(responseMessage, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = WrongMessageLengthException.class)
    public ResponseEntity<Object> handleWrongMessageLengthException(WrongMessageLengthException e) {
        ResponseMessage responseMessage = new ResponseMessage(e.getMessage(), LocalDateTime.now());
        return new ResponseEntity<>(responseMessage, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = WrongMessageCharactersException.class)
    public ResponseEntity<Object> handleWrongMessageCharactersException(WrongMessageCharactersException e) {
        ResponseMessage responseMessage = new ResponseMessage(e.getMessage(), LocalDateTime.now());
        return new ResponseEntity<>(responseMessage, HttpStatus.BAD_REQUEST);
    }
}
