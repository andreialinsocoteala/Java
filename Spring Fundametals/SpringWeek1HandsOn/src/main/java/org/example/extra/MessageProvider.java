package org.example.extra;

public class MessageProvider {

    public MessageProvider() {
        System.out.println("Constructing MessageProvider");
    }

    public String getMessage() {
        return "Hello from @Bean!";
    }
}
