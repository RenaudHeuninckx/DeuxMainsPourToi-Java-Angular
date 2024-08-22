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

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "ActualiteId")
    private Actualite actualite;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "EvenementId")
    private Evenement evenement;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "MassageId")
    private Massage massage;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "PackOffreId")
    private PackOffre packOffre;

    @Column(name = "Creation_date", nullable = false)
    private LocalDate creationDate;

    @Column(name = "ModifiedDate", nullable = false)
    private LocalDate modifiedDate;

    @Column(name = "DeletedDate")
    private LocalDate deletedDate;

}
