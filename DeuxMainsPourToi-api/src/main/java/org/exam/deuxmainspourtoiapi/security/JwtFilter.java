package org.exam.deuxmainspourtoiapi.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.exam.deuxmainspourtoiapi.dto.UtilisateurDto;
import org.exam.deuxmainspourtoiapi.service.UtilisateurServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;

@Component
public class JwtFilter extends OncePerRequestFilter {

    private JwtUtil jwtUtil;

    private UtilisateurServiceImpl utilisateurServiceImpl;

    public JwtFilter(JwtUtil jwtUtil, UtilisateurServiceImpl utilisateurServiceImpl) {
        this.jwtUtil = jwtUtil;
        this.utilisateurServiceImpl = utilisateurServiceImpl;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        System.out.println("doFilterInternal");
        final String authorizationHeader = request.getHeader("Authorization");

        String subject = null;
        String jwtToken = null;

        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            jwtToken = authorizationHeader.substring(7);
            subject = jwtUtil.extractSubject(jwtToken);
        }

        if (subject != null && SecurityContextHolder.getContext().getAuthentication() == null) {

            UtilisateurDto utilisateurDto = utilisateurServiceImpl.getUtilisateurDtoByEmail(subject);

            if (jwtUtil.validateToken(jwtToken, utilisateurDto)){
                List<String> roles = jwtUtil.extractRoles(jwtToken);
                List<SimpleGrantedAuthority> authorities = roles.stream().map(SimpleGrantedAuthority::new ).toList();
                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                        new UsernamePasswordAuthenticationToken(utilisateurDto, null, authorities);
                usernamePasswordAuthenticationToken
                        .setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            }
        }
        filterChain.doFilter(request, response);
    }
}
