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
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    UtilisateurServiceImpl utilisateurServiceImpl;

    @Autowired
    JwtUtil jwtUtil;

    @Autowired
    DaoAuthenticationProvider authenticationProvider;

    @Autowired
    PasswordEncoder passwordEncoder;

    @GetMapping("/isnewemail/{email}")
    public ResponseEntity<String> isNewEmail(@PathVariable String email) {
        boolean isNewEmail = utilisateurServiceImpl.isEmailExist(email);
        if (isNewEmail) {
            return ResponseEntity.ok().body("true");
        } else {
            return ResponseEntity.ok().body("false");
        }
    }

    @GetMapping("/isnewpseudo/{pseudo}")
    public ResponseEntity<String> isNewPseudo(@PathVariable String pseudo) {
        boolean isNewPseudo = utilisateurServiceImpl.isPseudoExist(pseudo);
        if (isNewPseudo) {
            return ResponseEntity.ok().body("true");
        } else {
            return ResponseEntity.ok().body("false");
        }
    }

    @PostMapping("/register")
    public ResponseEntity<String> signup(@RequestBody UtilisateurDto utilisateurDto) {
        try {
            utilisateurDto.setPassword(passwordEncoder.encode(utilisateurDto.getPassword()));
            utilisateurServiceImpl.createUtilisateurDto(utilisateurDto);
            return ResponseEntity.ok().build();

        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody AuthRequest authRequest) {
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
        return ResponseEntity.ok().body(new AuthResponse(token));
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
