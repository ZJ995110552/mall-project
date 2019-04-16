package com.mercury.mallproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
