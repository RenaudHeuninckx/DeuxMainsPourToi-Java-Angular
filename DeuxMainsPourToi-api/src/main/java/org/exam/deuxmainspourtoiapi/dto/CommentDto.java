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
    private Integer Utilisateur;
    private String commentaire;
    private Integer actualiteId;
    private Integer evenementId;
    private Integer massageId;
    private Integer packOffreId;
    private LocalDate creationDate;
    private LocalDate modifiedDate;
    private LocalDate deletedDate;
}
