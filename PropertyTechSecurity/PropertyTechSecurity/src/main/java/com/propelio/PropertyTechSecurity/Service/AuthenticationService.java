package com.propelio.PropertyTechSecurity.Service;

import com.propelio.PropertyTechSecurity.Entity.PropertyRole;
import com.propelio.PropertyTechSecurity.Entity.PropertySecurity;
import com.propelio.PropertyTechSecurity.Repository.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    public String saveUser(PropertySecurity security_user) {
        security_user.setUser_password(passwordEncoder.encode(security_user.getUser_password()));
        propertyRepository.save(security_user);
        return "User added to the system";
    }
    public String generateToken(String username) {
        return jwtService.generateToken(username);
    }
    public void validateToken(String token) {
        jwtService.validateToken(token);
    }
}
