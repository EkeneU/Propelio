package com.propelio.PropertyTechSecurity.Config;

import com.propelio.PropertyTechSecurity.Entity.PropertySecurity;
import com.propelio.PropertyTechSecurity.Repository.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class PropertyTechDetailsService implements UserDetailsService {

    @Autowired
    public PropertyRepository propertyRepository;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<PropertySecurity> repositoryOptional = propertyRepository.findByEmail(email);

        return repositoryOptional.map(PropertyUserDetails::new).orElseThrow(() -> new UsernameNotFoundException("Inputed user not found with email : " + email));
    }
}
