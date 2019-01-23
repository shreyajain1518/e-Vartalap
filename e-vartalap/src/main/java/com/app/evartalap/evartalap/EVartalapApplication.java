package com.app.evartalap.evartalap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class EVartalapApplication {

	public static void main(String[] args) {
		SpringApplication.run(EVartalapApplication.class, args);
	}

}

