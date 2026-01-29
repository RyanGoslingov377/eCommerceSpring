package com.jtspringproject.JtSpringProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.jtspringproject.JtSpringProject.models")
public class JtSpringProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(JtSpringProjectApplication.class, args);
	}
}

