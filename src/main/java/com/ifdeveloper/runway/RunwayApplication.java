package com.ifdeveloper.runway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RunwayApplication {

	public static void main(String[] args) {
		System.out.println("Logando alguma coisa");
		SpringApplication.run(RunwayApplication.class, args);
	}

}
