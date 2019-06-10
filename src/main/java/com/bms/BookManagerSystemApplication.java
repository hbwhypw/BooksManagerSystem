package com.bms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@SpringBootApplication(scanBasePackages = "com.bms")
public class BookManagerSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookManagerSystemApplication.class, args);
	}

}
