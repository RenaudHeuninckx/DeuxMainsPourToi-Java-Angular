package org.exam.deuxmainspourtoiapi.security;

import org.exam.deuxmainspourtoiapi.entity.Utilisateur;
import org.exam.deuxmainspourtoiapi.repository.UtilisateurRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class CustomUserDetailsService implements UserDetailsService {

    private final UtilisateurRepository utilisateurRepository;

    public CustomUserDetailsService(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Utilisateur utilisateur = utilisateurRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException(username));
        SimpleGrantedAuthority authority = utilisateur.getAdmin() ? new SimpleGrantedAuthority("ROLE_ADMIN") : new SimpleGrantedAuthority("ROLE_USER");
        List<SimpleGrantedAuthority> authorities = Collections.singletonList(authority);
        boolean enabled = (Objects.isNull(utilisateur.getDeletedDate()) || utilisateur.getDeletedDate().isAfter(LocalDate.now()));
        return new User(
                utilisateur.getEmail(),
                utilisateur.getPassword(),
                enabled,
                true,
                true,
                true,
                authorities
        );
    }
}
