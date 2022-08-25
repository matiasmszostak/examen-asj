package com.asj.examen.examenbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.asj.examen.examenbackend.models")
		public class ExamenBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExamenBackendApplication.class, args);
	}

}