package com.propelio.PropertyTechApiGateway.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Objects;

@Component
public class PropertyApiGatewayFilter extends AbstractGatewayFilterFactory<PropertyApiGatewayFilter.NameConfig> {
    @Autowired
    private  JwtGatewayService jwtGatewayService;
    @Autowired
    private  RouteValidator validator;
//    @Autowired
//    private RestTemplate template;

    public PropertyApiGatewayFilter(){
        super(NameConfig.class);
    }

    @Override
    public GatewayFilter apply(NameConfig config) {
        return (new GatewayFilter() {
            @Override
            public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
                if (validator.isSecured.test(exchange.getRequest())) {
                    //header contains token or not
                    if (!exchange.getRequest().getHeaders().containsKey(HttpHeaders.AUTHORIZATION)) {
                        throw new RuntimeException("missing authorization header");
                    }

                    String authHeader = Objects.requireNonNull(exchange.getRequest().getHeaders().get(HttpHeaders.AUTHORIZATION)).get(0);
                    if (authHeader != null && authHeader.startsWith("Bearer ")) {
                        authHeader = authHeader.substring(7);
                    }
                    try {
//                    //REST call to AUTH service
//                    template.getForObject("http://IDENTITY-SERVICE//validate?token" + authHeader, String.class);
                        jwtGatewayService.validateToken(authHeader);

                    } catch (Exception e) {
                        System.out.println("invalid access...!");
                        throw new RuntimeException("un authorized access to application");
                    }
                }
                return chain.filter(exchange);
            }
        });
    }


    public static class NameConfig {

    }
}
