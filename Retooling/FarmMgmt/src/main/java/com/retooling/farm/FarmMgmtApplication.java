package com.retooling.farm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class FarmMgmtApplication {

	public static void main(String[] args) {
		SpringApplication.run(FarmMgmtApplication.class, args);
		System.out.println("Iniciando FarmMgmtApplication...");
	}

}
