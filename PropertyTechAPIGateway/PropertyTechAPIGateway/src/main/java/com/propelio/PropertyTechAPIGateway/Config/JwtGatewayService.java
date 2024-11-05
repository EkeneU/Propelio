package com.propelio.PropertyTechAPIGateway.Config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.security.Key;
import java.util.Date;

@Component
public class JwtGatewayService {
    public static final String SECRET_KEY = "QKDHW7kjHov0tg1SLOIhN/LmrAy0SMdLU+zEmmRQvGZxuAB/GNEvgZwvb310dgUD";

    private SecretKey key;

    public void validateToken(final String token) {
        Jwts.parser().verifyWith(getSignKey()).build().parseEncryptedClaims(token);
    }

    private SecretKey getSignKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    public Claims getAllClaimsFromToken(String token) {
        return Jwts.parser().verifyWith(key).build().parseSignedClaims(token).getPayload();
    }

    private boolean isTokenExpired(String token) {
        return this.getAllClaimsFromToken(token).getExpiration().before(new Date());
    }

    public boolean isInvalid(String token) {
        return this.isTokenExpired(token);
    }


}

