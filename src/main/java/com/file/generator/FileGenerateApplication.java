package com.file.generator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class FileGenerateApplication {

	public static void main(String[] args) {
		SpringApplication.run(FileGenerateApplication.class, args);
	}

}
