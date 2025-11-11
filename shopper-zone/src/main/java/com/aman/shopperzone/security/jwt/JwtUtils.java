package com.aman.shopperzone.security.jwt;

import com.aman.shopperzone.security.user.ShopUserDetails;
import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.List;

@Component
public class JwtUtils {

    @Value("${auth.token.jwtSecret}")
    private String jwtSecret;

    @Value("${auth.token.expirationInMills}")
    private int expirationTime;

    public String generateTokenForUser(Authentication authentication) {
        ShopUserDetails userPrinciple = (ShopUserDetails) authentication.getPrincipal();
        List<String> roles = userPrinciple.getAuthorities()
                .stream()
                .map(GrantedAuthority::getAuthority).toList();
        return Jwts.builder()
                .setSubject(userPrinciple.getEmail())
                .claim("id", userPrinciple.getId())
                .claim("roles", roles)
                .issuedAt(new Date())
                .setExpiration(new Date((new Date()).getTime() + expirationTime))
                .signWith(key(), SignatureAlgorithm.HS256).compact();
    }

    private Key key() {
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtSecret));
    }

    public String getUserNameFromToken(String token) {
        return Jwts.parser()
                .setSigningKey(key())
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parser()
                    .setSigningKey(key())
                    .build()
                    .parseClaimsJws(token);
            return true;
        } catch (ExpiredJwtException
                 | UnsupportedJwtException
                 | MalformedJwtException
                 | IllegalArgumentException
                 | io.jsonwebtoken.security.SecurityException e) {
            throw new JwtException(e.getMessage());
        }
    }

}
