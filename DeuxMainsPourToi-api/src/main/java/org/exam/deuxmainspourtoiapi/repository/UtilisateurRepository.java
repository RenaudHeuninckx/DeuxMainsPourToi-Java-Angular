package org.exam.deuxmainspourtoiapi.repository;

import org.exam.deuxmainspourtoiapi.entity.Utilisateur;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UtilisateurRepository extends CrudRepository<Utilisateur, Integer> {
    Optional<Utilisateur> findByEmail(String email);
    Optional<Utilisateur> findByPseudo(String pseudo);
}
