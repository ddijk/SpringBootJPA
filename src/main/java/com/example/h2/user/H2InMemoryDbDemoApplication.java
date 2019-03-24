package com.example.h2.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
public class H2InMemoryDbDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(H2InMemoryDbDemoApplication.class, args);
	}

}
