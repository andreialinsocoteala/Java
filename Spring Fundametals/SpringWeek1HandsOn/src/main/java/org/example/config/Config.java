package org.example.config;

import org.example.extra.MessageProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration   // - Indicates that this class contains Spring configuration
@ComponentScan(basePackages = "org.example")   // - Scans the specified package for Spring components
@EnableAspectJAutoProxy   // - Enables support for handling components marked with AspectJ's @Aspect annotation
public class Config {

    @Bean   // - Defines a bean named "messageProvider" managed by the Spring container
    public MessageProvider messageProvider() {
        return new MessageProvider();
    }
}
