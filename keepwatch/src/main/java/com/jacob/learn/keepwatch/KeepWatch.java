package com.jacob.learn.keepwatch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages="com.jacob.learn")
@EnableJpaRepositories(basePackages={"com.jacob.learn", "com.jacob.blala"})
@EntityScan(basePackages={"com.jacob.learn", "com.jacob.learn"})
public class KeepWatch {
    public static void main(String[] args) {
        SpringApplication.run(KeepWatch.class, args);
    }
}
