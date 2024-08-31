package org.exam.deuxmainspourtoiapi.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false)
    private Integer id;

    @Column(name = "UtilisateurId", nullable = false)
    private Integer utilisateurId;

    @Column(name = "Commentaire", nullable = false, length = 2048)
    private String commentaire;

    @Column(name = "ActualiteId")
    private Integer actualiteId;

    @Column(name = "EvenementId")
    private Integer evenementId;

    @Column(name = "MassageId")
    private Integer massageId;

    @Column(name = "PackOffreId")
    private Integer packOffreId;

    @Column(name = "Creation_date", nullable = false)
    private LocalDate creationDate;

    @Column(name = "ModifiedDate", nullable = false)
    private LocalDate modifiedDate;

    @Column(name = "DeletedDate")
    private LocalDate deletedDate;

}
