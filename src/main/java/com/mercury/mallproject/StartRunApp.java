package com.mercury.mallproject;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@ComponentScan("com.mercury.mallproject.*")
@MapperScan(basePackages = {"com.mercury.mallproject.project.mapper", "com.mercury.mallproject.project.mapper.*", "com.mercury.mallproject.job.repository.mapper", "com.mercury.mallproject.fastdfs.repository.mapper","com.mercury.mallproject.log.mapper"})
@SpringBootApplication
@EnableSwagger2
public class StartRunApp {

    public static void main(String[] args) {
        SpringApplication.run(StartRunApp.class, args);
    }

}