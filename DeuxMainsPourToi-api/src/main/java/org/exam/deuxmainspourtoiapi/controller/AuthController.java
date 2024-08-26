package org.exam.deuxmainspourtoiapi.controller;

import lombok.Getter;
import lombok.Setter;
import org.exam.deuxmainspourtoiapi.dto.UtilisateurDto;
import org.exam.deuxmainspourtoiapi.security.JwtUtil;
import org.exam.deuxmainspourtoiapi.service.UtilisateurServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    UtilisateurServiceImpl utilisateurServiceImpl;

    @Autowired
    JwtUtil jwtUtil;

    @Autowired
    DaoAuthenticationProvider authenticationProvider;

    @GetMapping("/isnewemail/{email}")
    public ResponseEntity<String> isNewEmail(@PathVariable String email) {
        boolean isNewEmail = utilisateurServiceImpl.isEmailExist(email);
        if (isNewEmail) {
            return ResponseEntity.ok().body("L'email est déja utilisé");
        } else {
            return ResponseEntity.ok().body("Email ok.");
        }
    }

    @GetMapping("/isnewpseudo/{pseudo}")
    public ResponseEntity<String> isNewPseudo(@PathVariable String pseudo) {
        boolean isNewPseudo = utilisateurServiceImpl.isPseudoExist(pseudo);
        if (isNewPseudo) {
            return ResponseEntity.ok().body("Le pseudo est déja utilisé");
        } else {
            return ResponseEntity.ok().body("Pseudo ok.");
        }
    }

    @PostMapping("/register")
    public ResponseEntity<String> signup(@RequestBody UtilisateurDto utilisateurDto) {
        try {
            utilisateurServiceImpl.createUtilisateurDto(utilisateurDto);
            return ResponseEntity.ok().body("Utilisateur created");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Utilisateur creation error : " + e.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody AuthRequest authRequest) {
        try {
            authenticationProvider.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getEmail(), authRequest.getPassword()));
        } catch (BadCredentialsException e) {
            return ResponseEntity.badRequest().body("email ou mot de passe incorrecte.");
        } catch (DisabledException e) {
            return ResponseEntity.badRequest().body("Utilisateur inconnu");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("erreur : " + e.getMessage());
        }
        final UtilisateurDto utilisateurDto = utilisateurServiceImpl.getUtilisateurDtoByEmail(authRequest.getEmail());
        final String token = jwtUtil.generateToken(utilisateurDto);
        return ResponseEntity.ok().body(token);
    }

    @Getter
    @Setter
    static class AuthRequest {

        private String email;
        private String password;
    }

    static class AuthResponse {
        private String token;

        public AuthResponse(String token) {
            this.token = token;
        }

        public String getToken() {
            return token;
        }
    }

}
