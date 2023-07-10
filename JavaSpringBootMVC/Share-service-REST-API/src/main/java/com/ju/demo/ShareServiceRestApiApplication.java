package com.ju.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.ju")
public class ShareServiceRestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShareServiceRestApiApplication.class, args);
	}

}
