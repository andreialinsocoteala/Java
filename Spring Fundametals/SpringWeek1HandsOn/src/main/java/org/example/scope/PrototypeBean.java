package org.example.scope;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class PrototypeBean {

    public PrototypeBean() {
        System.out.println(">>> PrototypeBean constructor called: " + System.currentTimeMillis());
    }

    public void doWork() {
        System.out.println("PrototypeBean instance: " + this);
    }
}