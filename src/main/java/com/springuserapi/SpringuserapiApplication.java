package com.springuserapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SpringuserapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringuserapiApplication.class, args);
	}

}
