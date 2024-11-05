package com.propelio.PropertyTechAPIGateway.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {
    @Autowired
    private PropertyApiGatewayFilter filter;


    @Bean
    public RouteLocator routes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("PropertyTechSecurity", r -> r.path("/propertytechsecurity/**")
                        .filters(f -> f.filter(filter))
                        .uri("lb://PROPERTYTECHSECURITY"))

                .route("PropelioLandingPage", r -> r.path("/propelio/**")
                        .filters(f -> f.filter(filter))
                        .uri("lb://PROPELIOLANDINGPAGE"))
                .route("PropertyTechSearch", r -> r.path("/propertytechsearch/**")
                        .filters(f -> f.filter(filter))
                        .uri("lb://PROPERTYTECHSEARCH"))
                .build();
    }

}
