package com.jacob.learn.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages="com.jacob.learn")
@EnableJpaRepositories(basePackages="com.jacob.learn")
@EntityScan(basePackages="com.jacob.learn")
@EnableCaching
public class Api {
    public static void main(String[] args) {
        SpringApplication.run(Api.class, args);
    }
}
