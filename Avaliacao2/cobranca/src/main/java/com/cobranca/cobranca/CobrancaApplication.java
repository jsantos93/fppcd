package com.cobranca.cobranca;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CobrancaApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(CobrancaApplication.class);

		app.setDefaultProperties(Collections.singletonMap("server.port", "8081"));

		app.run(args);
	}

}
