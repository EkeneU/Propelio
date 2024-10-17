package com.propelio.PropertyTechSecurity.Controller;

import com.propelio.PropertyTechSecurity.DTO.AuthenticationRequest;
import com.propelio.PropertyTechSecurity.Entity.PropertySecurity;
import com.propelio.PropertyTechSecurity.Service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/propertytechsecurity/api/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationService service;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/register")
    public String addNewUser(@RequestBody PropertySecurity user) {
        System.out.println("About to register...");
        return service.saveUser(user);
    }

    @PostMapping("/token")
    public String getToken(@RequestBody AuthenticationRequest authRequest) {
        System.out.println("Attempting to get token...");
        Authentication authenticate =
                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getEmail(), authRequest.getUser_password()));
        if (authenticate.isAuthenticated()) {
            return service.generateToken(authRequest.getEmail());
        } else {
            throw new RuntimeException("invalid access");
        }
    }

    @GetMapping("/validate")
    public String validateToken(@RequestParam("token") String token) {
        service.validateToken(token);
        return "Token is valid";
    }
}
