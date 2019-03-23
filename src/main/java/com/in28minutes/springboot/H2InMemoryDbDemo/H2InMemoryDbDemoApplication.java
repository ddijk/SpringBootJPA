package com.in28minutes.springboot.H2InMemoryDbDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication(scanBasePackages = {"com.in28minutes", "com.example"})
@EntityScan( basePackages = {"com.example"})
public class H2InMemoryDbDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(H2InMemoryDbDemoApplication.class, args);
	}

}
