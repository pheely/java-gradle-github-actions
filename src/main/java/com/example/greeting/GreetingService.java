package com.example.greeting;

import org.springframework.stereotype.Service;

@Service
public class GreetingService {

    public String greet(String name) {
        String cleaned = name == null ? "" : name.trim();
        String who = cleaned.isEmpty() ? "World" : cleaned;
        return "Hello, " + capitalize(who) + "!";
    }

    private String capitalize(String s) {
        if (s.isEmpty()) return s;
        return s.substring(0, 1).toUpperCase() + s.substring(1);
    }
}
