package org.example;


import org.example.config.Config;
import org.example.scope.ScopeClient;
import org.example.service.GreetingClient;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {

        try (AnnotationConfigApplicationContext ctx =
                     new AnnotationConfigApplicationContext(Config.class)) {

            GreetingClient greetingClient = ctx.getBean(GreetingClient.class);
            greetingClient.doGreet("World");

            System.out.println();
            ScopeClient scopeClient = ctx.getBean(ScopeClient.class);
            scopeClient.testScopes();
        }
    }
}
