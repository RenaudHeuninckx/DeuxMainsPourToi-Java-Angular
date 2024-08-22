package org.exam.deuxmainspourtoiapi.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Getter
@Setter
@Entity
@Table(name = "evenement_content")
public class EvenementContent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "EvenementId", nullable = false)
    private Evenement evenement;

    @Column(name = "Description", nullable = false, length = 2048)
    private String description;

    @Column(name = "Image", length = 1024)
    private String image;

    @Column(name = "Rang", nullable = false)
    private Integer rang;

}
