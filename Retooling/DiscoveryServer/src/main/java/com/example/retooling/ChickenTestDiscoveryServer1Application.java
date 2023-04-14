package com.example.retooling;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ChickenTestDiscoveryServer1Application {

	public static void main(String[] args) {
		SpringApplication.run(ChickenTestDiscoveryServer1Application.class, args);
	}

}
