package com.propelio.PropertyTechSecurity.Service;

import com.propelio.PropertyTechSecurity.Entity.PropertySecurity;
import com.propelio.PropertyTechSecurity.Repository.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    @Autowired
    private PropertyRepository propertyRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtService jwtService;

    public String saveUser(PropertySecurity user) {
        user.setUser_password(passwordEncoder.encode(user.getUser_password()));
        propertyRepository.save(user);
        return "user added to the system";
    }

    public String generateToken(String username) {
        return jwtService.generateToken(username);
    }

    public void validateToken(String token) {
        jwtService.validateToken(token);
    }

}
