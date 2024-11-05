package com.propelio.PropertyTechSecurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class PropertyTechSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(PropertyTechSecurityApplication.class, args);
	}

}
