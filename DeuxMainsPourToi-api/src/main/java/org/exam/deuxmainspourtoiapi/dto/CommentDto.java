package org.exam.deuxmainspourtoiapi.dto;

import lombok.Data;
import org.exam.deuxmainspourtoiapi.entity.Actualite;
import org.exam.deuxmainspourtoiapi.entity.Evenement;
import org.exam.deuxmainspourtoiapi.entity.Massage;
import org.exam.deuxmainspourtoiapi.entity.PackOffre;

import java.time.LocalDate;

@Data
public class CommentDto {
    private Integer Id;
    private UtilisateurDto Utilisateur;
    private String commentaire;
    private Actualite actualite;
    private Evenement evenement;
    private Massage massage;
    private PackOffre packOffre;
    private LocalDate creationDate;
    private LocalDate modifiedDate;
    private LocalDate deletedDate;
}
