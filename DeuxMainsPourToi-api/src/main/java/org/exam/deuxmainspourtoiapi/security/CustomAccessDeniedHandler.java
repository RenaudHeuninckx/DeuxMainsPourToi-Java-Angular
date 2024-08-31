package org.exam.deuxmainspourtoiapi.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import java.io.IOException;
import java.util.List;
import java.util.function.Function;

public class CustomAccessDeniedHandler implements AccessDeniedHandler {

    private String secret = "eyJhbGciOiJIUzI1NiJ9.eyJSb2xlIjoiQWRtaW4iLCJJc3N1ZXIiOiJJc3N1ZXIiLCJVc2VybmFtZSI6IkphdmFJblVzZSIsImV4cCI6MTcyNDY4MzYyMCwiaWF0IjoxNzI0NjgzNjIwfQ.-Bnl3QFRY7rbQ0JxwPOymd-sl_-eB2oMhBf3ZldZmdM";

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        System.out.println("Access Denied for user: " + request.getUserPrincipal().getName());
        System.out.println("Reason: " + accessDeniedException.getMessage());

        final String authorizationHeader = request.getHeader("Authorization");

        String subject = null;
        String roles = null;
        String jwtToken  = null;

        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            jwtToken = authorizationHeader.substring(7);
            subject = extractSubject(jwtToken);
            roles = extractRoles(jwtToken);
        }

        System.out.println("Token : " + jwtToken);
        System.out.println("subject : " + subject);
        System.out.println("roles : " + roles);

        response.sendError(HttpServletResponse.SC_FORBIDDEN, "Accès refusé : Vous n'avez pas les permissions nécessaires.");
    }

    public String extractSubject(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    public String extractRoles(String token) {
        Claims claims = extractAllClaims(token);
        return claims.get("roles", List.class).toString();
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimResolver) {
        final Claims claims = extractAllClaims(token);
        return claimResolver.apply(claims);
    }

    public Claims extractAllClaims(String token) {
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
    }

}
