package com.propelio.PropertyTechAPIGateway.Config;

import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class PropertyApiGatewayFilter implements GatewayFilter {
    @Autowired
    private JwtGatewayService jwtGatewayService;
    @Autowired
    private RouteValidator validator;

//    public GatewayFilter apply(NameConfig config) {
//        return (new GatewayFilter() {
//            @Override
//            public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
//                if (validator.isSecured.test(exchange.getRequest())) {
//                    //header contains token or not
//                    if (!exchange.getRequest().getHeaders().containsKey(HttpHeaders.AUTHORIZATION)) {
//                        throw new RuntimeException("missing authorization header");
//                    }
//                    String authHeader = exchange.getRequest().getHeaders().get(HttpHeaders.AUTHORIZATION).get(0);
////                    String authHeader = Objects.requireNonNull(exchange.getRequest().getHeaders().get(HttpHeaders.AUTHORIZATION)).get(0);
//                    if (authHeader != null && authHeader.startsWith("Bearer ")) {
//                        authHeader = authHeader.substring(7);
//                    }
//
//                    try{
//                        jwtGatewayService.validateToken(authHeader);
//                    }
//                    catch (Exception e) {
//                        System.out.println("Invalid Access");
//                        throw new RuntimeException("Unauthorized access to application");
//                    }
//                }
//                return chain.filter(exchange);
//            }
//        });
//    }

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();

        if (validator.isSecured.test(request)) {
            if (this.isAuthMissing(request)) {
                return this.onError(exchange, HttpStatus.UNAUTHORIZED);
            }

            final String token = this.getAuthHeader(request);

            if (jwtGatewayService.isInvalid(token)) {
                return this.onError(exchange, HttpStatus.FORBIDDEN);
            }

            this.updateRequest(exchange, token);
        }
        return chain.filter(exchange);
    }

    private Mono<Void> onError(ServerWebExchange exchange, HttpStatus httpStatus) {
        ServerHttpResponse response = exchange.getResponse();
        response.setStatusCode(httpStatus);
        return response.setComplete();
    }

    private String getAuthHeader(ServerHttpRequest request) {
        return request.getHeaders().getOrEmpty("Authorization").get(0);
    }

    private boolean isAuthMissing(ServerHttpRequest request) {
        return !request.getHeaders().containsKey("Authorization");
    }

    private void updateRequest(ServerWebExchange exchange, String token) {
        Claims claims = jwtGatewayService.getAllClaimsFromToken(token);
        exchange.getRequest().mutate()
                .header("email", String.valueOf(claims.get("email")))
                .build();
    }

//    public static class NameConfig {
//
//    }
}
