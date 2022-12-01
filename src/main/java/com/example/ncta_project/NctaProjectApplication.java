package com.example.ncta_project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class NctaProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(NctaProjectApplication.class, args);
	}

}
