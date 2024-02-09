package ru.mylov.numberofoccurrences.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.mylov.numberofoccurrences.services.CountService;

@RestController
@RequestMapping("/api")
public class MainController {
    private final CountService countService;

    @Autowired
    public MainController(CountService countService) {
        this.countService = countService;
    }

    @GetMapping("/count")
    public String count(@RequestParam String message) {
        return countService.countOccurrences(message);
    }
}
