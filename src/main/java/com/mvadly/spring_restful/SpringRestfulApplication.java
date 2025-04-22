package com.mvadly.spring_restful;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.mvadly.spring_restful")
public class SpringRestfulApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringRestfulApplication.class, args);
	}
}

