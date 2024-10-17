package com.propelio.PropertyTechApiGateway.Config;

import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Predicate;

@Component
public class RouteValidator {

    public static final List<String> openApiEndpoints = List.of(
            "/propertytechsecurity/api/auth/register",
            "/propertytechsecurity/api/auth/token",
            "/eureka"
    );

    public Predicate<ServerHttpRequest> isSecured =
            new Predicate<ServerHttpRequest>() {
                @Override
                public boolean test(ServerHttpRequest request) {
                    return openApiEndpoints
                            .stream()
                            .noneMatch(new Predicate<String>() {
                                @Override
                                public boolean test(String uri) {
                                    return request.getURI().getPath().contains(uri);
                                }
                            });
                }
            };
}
