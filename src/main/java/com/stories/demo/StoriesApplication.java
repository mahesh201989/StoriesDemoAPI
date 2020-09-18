package com.stories.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class StoriesApplication {
	public static void main(String[] args) {
		SpringApplication.run(StoriesApplication.class, args);
	}
}
