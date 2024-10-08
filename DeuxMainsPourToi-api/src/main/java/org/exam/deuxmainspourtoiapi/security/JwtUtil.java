package org.exam.deuxmainspourtoiapi.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.exam.deuxmainspourtoiapi.dto.UtilisateurDto;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.function.Function;

@Component
public class JwtUtil {

    private String secret = "eyJhbGciOiJIUzI1NiJ9.eyJSb2xlIjoiQWRtaW4iLCJJc3N1ZXIiOiJJc3N1ZXIiLCJVc2VybmFtZSI6IkphdmFJblVzZSIsImV4cCI6MTcyNDY4MzYyMCwiaWF0IjoxNzI0NjgzNjIwfQ.-Bnl3QFRY7rbQ0JxwPOymd-sl_-eB2oMhBf3ZldZmdM";

    public String generateToken(UtilisateurDto utilisateurDto) {
        Map<String, Object> claims = new HashMap<>();
        GrantedAuthority grantedAuthority = utilisateurDto.getAdmin() ? new SimpleGrantedAuthority("ADMIN") : new SimpleGrantedAuthority("USER");
        claims.put("roles", Collections.singletonList(grantedAuthority));
        claims.put("Id", utilisateurDto.getId());
        claims.put("pseudo", utilisateurDto.getPseudo());
        return createToken(claims, utilisateurDto.getEmail());
    }

    public String createToken(Map<String, Object> claims, String subject) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

    public Boolean validateToken(String token, UtilisateurDto utilisateurDto) {
        System.out.println("validateToken");
        final String email = extractSubject(token);
        return (email.equals(utilisateurDto.getEmail()) && !isTokenExpired(token));
    }

    public String extractSubject(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    public Boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    public Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimResolver) {
        final Claims claims = extractAllClaims(token);
        return claimResolver.apply(claims);
    }

    public List<String> extractRoles(String token) {
        Claims claims = extractAllClaims(token);
        List<Map<String, String>> rolesMap = claims.get("roles", List.class);
        return rolesMap.stream()
                .map(map -> map.get("authority"))
                .toList();
    }

    public Claims extractAllClaims(String token) {
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
    }
}
