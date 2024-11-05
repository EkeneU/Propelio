package com.propelio.PropertyTechAPIGateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class PropertyTechApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(PropertyTechApiGatewayApplication.class, args);
	}

}
