package com.retooling.egg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EggMgmtApplication {

	public static void main(String[] args) {
		SpringApplication.run(EggMgmtApplication.class, args);
		System.out.println("Iniciando EggMgmtApplication...");
	}

}
