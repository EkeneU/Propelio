package com.propelio.PropertyTechSecurity.Repository;

import com.propelio.PropertyTechSecurity.Entity.PropertySecurity;
import org.bouncycastle.jcajce.provider.asymmetric.rsa.CipherSpi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PropertyRepository extends JpaRepository<PropertySecurity, Integer> {
    Optional<PropertySecurity> findByEmail(String email);
}
