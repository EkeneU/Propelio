package com.propelio.PropertyTechSearch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class PropertyTechSearchApplication {

	public static void main(String[] args) {
		SpringApplication.run(PropertyTechSearchApplication.class, args);
	}

}
