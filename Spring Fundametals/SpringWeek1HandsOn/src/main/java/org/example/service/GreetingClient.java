package org.example.service;

import org.example.extra.MessageProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class GreetingClient {

    private final Greeting greetingService;

    @Autowired
    private MessageProvider messageProvider;

    public GreetingClient(@Qualifier("formalGreeting") Greeting greetingService) {
        this.greetingService = greetingService;
    }

    public void doGreet(String name) {
        String msg = greetingService.greet(name);
        System.out.println(msg);

        System.out.println("Extra from @Bean: " + messageProvider.getMessage());
    }
}

