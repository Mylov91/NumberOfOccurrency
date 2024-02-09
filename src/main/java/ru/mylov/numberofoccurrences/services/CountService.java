package ru.mylov.numberofoccurrences.services;

import org.springframework.stereotype.Service;
import ru.mylov.numberofoccurrences.exceptions.EmptyMessageException;
import ru.mylov.numberofoccurrences.exceptions.WrongMessageCharactersException;
import ru.mylov.numberofoccurrences.exceptions.WrongMessageLengthException;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Pattern;

@Service
public class CountService {
    public String countOccurrences(String message) {
        Map<Character, Integer> freq = new LinkedHashMap<>();
        char[] chars = message.toCharArray();
        for (char ch : chars) {
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
        }
        Map<Character, Integer> orderedMap = freq.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(LinkedHashMap::new,
                        (m, c) -> m.put(c.getKey(), c.getValue()),
                        LinkedHashMap::putAll);
        if (message.length() > 20) {
            throw new WrongMessageLengthException("Message must be less than 20 characters");
        } else if (message.isEmpty()) {
            throw new EmptyMessageException("Message must not be empty");
        } else if (!Pattern.matches("[a-zA-Z]+", message)) {
            throw new WrongMessageCharactersException("Message must contain only letters");
        } else {
            return orderedMap.toString();
        }
    }
}
