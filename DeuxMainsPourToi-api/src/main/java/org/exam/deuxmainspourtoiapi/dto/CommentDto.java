package org.exam.deuxmainspourtoiapi.dto;

import lombok.Getter;
import lombok.Setter;
import org.exam.deuxmainspourtoiapi.entity.Actualite;
import org.exam.deuxmainspourtoiapi.entity.Evenement;
import org.exam.deuxmainspourtoiapi.entity.Massage;
import org.exam.deuxmainspourtoiapi.entity.PackOffre;

import java.time.LocalDate;

@Getter
@Setter
public class CommentDto {

    public CommentDto() {
    }

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
