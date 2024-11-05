package com.propelio.PropertyTechNamingServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class PropertyTechNamingServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(PropertyTechNamingServerApplication.class, args);
	}

}
