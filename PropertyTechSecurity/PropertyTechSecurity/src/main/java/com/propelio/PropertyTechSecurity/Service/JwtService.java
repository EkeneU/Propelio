package com.propelio.PropertyTechSecurity.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class JwtService {
    public static final String SECRET_KEY = "QKDHW7kjHov0tg1SLOIhN/LmrAy0SMdLU+zEmmRQvGZxuAB/GNEvgZwvb310dgUD";

    public void validateToken(final String token) {
        Jwts.parser().verifyWith(getSignKey()).build().parseEncryptedClaims(token);

    }

    // Calls the createToken method
    public String generateToken(String userName) {
        Map<String, Object> claims = new HashMap<>();
        return createToken(claims, userName);
    }
    private String createToken(Map<String, Object> claims, String userName) {
        return Jwts
                .builder()
                .claims(claims)
                .subject(userName)
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 30))
                .signWith(getSignKey(), Jwts.SIG.HS256).compact();
    }
    private SecretKey getSignKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
