package com.rentacar.rentacar_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
public class RentacarServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RentacarServiceApplication.class, args);
	}

}
