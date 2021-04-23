package com.app.easy2excel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.app.easy2excel")
public class SpringbootWithSwaggerExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootWithSwaggerExampleApplication.class, args);
		System.out.println("swagger 2 integrated...");
	}

}
