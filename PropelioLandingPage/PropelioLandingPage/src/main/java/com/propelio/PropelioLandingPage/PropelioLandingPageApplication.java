package com.propelio.PropelioLandingPage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class PropelioLandingPageApplication {

	public static void main(String[] args) {
		SpringApplication.run(PropelioLandingPageApplication.class, args);
	}

}
