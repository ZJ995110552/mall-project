package com.mercury.mallproject;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@ComponentScan("com.mercury.mallproject.*")
@MapperScan(basePackages = {"com.mercury.mallproject.repository.mapper","com.mercury.mallproject.repository.mapper.*"})
@Controller
@SpringBootApplication
public class MallProjectApplication {

	@ResponseBody
	@RequestMapping("/index")
	public String home(){
		return "Hello World!";
	}

	public static void main(String[] args) {
		SpringApplication.run(MallProjectApplication.class, args);
	}

}