package com.meritamerica.assignment5;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.MeritBankApp")
public class MeritAmericaBankApplication {

	public static void main(String[] args) {
		SpringApplication.run(MeritAmericaBankApplication.class, args);
	}

}