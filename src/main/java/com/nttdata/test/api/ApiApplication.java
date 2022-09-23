package com.nttdata.test.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = { "com.nttdata.test.api.model", "com.nttdata.test.api.controller",
		"com.nttdata.test.api.service","com.nttdata.test.api.validator" })
public class ApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}

}
