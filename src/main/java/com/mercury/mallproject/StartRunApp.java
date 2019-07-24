package com.mercury.mallproject;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@ComponentScan("com.mercury.mallproject.*")
@MapperScan(basePackages = {"com.mercury.mallproject.repository.mapper", "com.mercury.mallproject.repository.mapper.*", "com.mercury.mallproject.job.repository.mapper"})
@SpringBootApplication
public class StartRunApp {

    public static void main(String[] args) {
        SpringApplication.run(StartRunApp.class, args);
    }

}