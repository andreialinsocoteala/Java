package org.example.service;

import org.springframework.stereotype.Service;

@Service("casualGreeting")
public class CasualGreeting implements Greeting {

    public CasualGreeting() {
        System.out.println("Constructing CasualGreeting instance");
    }

    @Override
    public String greet(String name) {
        return "Hey " + name + "! What's up?";
    }
}
