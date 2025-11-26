package org.example.scope;

import org.springframework.stereotype.Component;

@Component
public class SingletonBean {

    public SingletonBean() {
        System.out.println(">>> SingletonBean constructor called: " + System.currentTimeMillis());
    }

    public void doWork() {
        System.out.println("SingletonBean instance: " + this);
    }
}