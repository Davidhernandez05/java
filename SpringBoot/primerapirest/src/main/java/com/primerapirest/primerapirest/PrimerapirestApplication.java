package com.primerapirest.primerapirest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
// @PropertySource("classpath:messages.properties") -> Se puede traer desde aquí o desde un archivo nuevo llamado config.
public class PrimerapirestApplication {

	public static void main(String[] args) {
		SpringApplication.run(PrimerapirestApplication.class, args);
	}

}
