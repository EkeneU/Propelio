package com.propelio.PropertyTechAPIGateway.Config;

import org.springframework.stereotype.Component;
import org.springframework.http.server.reactive.ServerHttpRequest;

import java.util.*;
import java.util.function.Predicate;

@Component
public class RouteValidator {
    public static final List<String> openApiEndpoints = List.of(
            "/propertytechsecurity/api/auth/register",
            "/propertytechsecurity/api/auth/token",
            "/eureka"
    );

//    public Predicate<ServerHttpRequest> isSecured =
//            new Predicate<ServerHttpRequest>() {
//                @Override
//                public boolean test(ServerHttpRequest serverHttpRequest) {
//                    return openApiEndpoints.stream().noneMatch(new Predicate<String>() {
//                        @Override
//                        public boolean test(String s) {
//                            return serverHttpRequest.getURI().getPath().equals(s);
//                        }
//                    });
//                }
//            };

    public Predicate<ServerHttpRequest> isSecured = new Predicate<ServerHttpRequest>() {
        @Override
        public boolean test(ServerHttpRequest serverHttpRequest) {
            String path = serverHttpRequest.getURI().getPath();
            boolean isSecured;
            boolean b = true;
            for (String openApiEndpoint : openApiEndpoints) {
                if (path.contains(openApiEndpoint)) {
                    b = false;
                    break;
                }
            }
            if (b) {
                isSecured = true;
            } else isSecured = false;
            System.out.println("Request path: " + path + " | Is secured: " + isSecured);
            return isSecured;
        }
    };

}
