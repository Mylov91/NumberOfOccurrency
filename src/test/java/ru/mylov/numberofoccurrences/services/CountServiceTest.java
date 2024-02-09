package ru.mylov.numberofoccurrences.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.mylov.numberofoccurrences.exceptions.EmptyMessageException;
import ru.mylov.numberofoccurrences.exceptions.WrongMessageCharactersException;
import ru.mylov.numberofoccurrences.exceptions.WrongMessageLengthException;

class CountServiceTest {
    private CountService countService;

    @BeforeEach
    void setUp() {
        countService = new CountService();
    }

    @Test
    void testCountOccurrences_correctCount() {
        String testMessage = countService.countOccurrences("aaaaabcccc");
        Assertions.assertEquals("{a=5, c=4, b=1}", testMessage);
    }

    @Test
    void testCountOccurrences_throwEmptyMessageException() {
        Assertions.assertThrows(EmptyMessageException.class, () -> {
            countService.countOccurrences("");
        });
    }

    @Test
    void testCountOccurrences_throwWrongMessageCharactersException() {
        Assertions.assertThrows(WrongMessageCharactersException.class, () -> {
            countService.countOccurrences("aaaaab1cccc");
        });
    }

    @Test
    void testCountOccurrences_throwMessageLengthException() {
        Assertions.assertThrows(WrongMessageLengthException.class, () -> {
            countService.countOccurrences("aaaaabccccccccccccccccccccccccccccccccc");
        });
    }
}
