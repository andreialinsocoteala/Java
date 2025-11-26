package org.example.service;

import org.springframework.stereotype.Service;

@Service("formalGreeting")
public class FormalGreeting implements Greeting {

    public FormalGreeting() {
        System.out.println("Constructing FormalGreeting instance");
    }

    @Override
    public String greet(String name) {
        return "Good day, " + name + ". It is a pleasure to meet you.";
    }
}