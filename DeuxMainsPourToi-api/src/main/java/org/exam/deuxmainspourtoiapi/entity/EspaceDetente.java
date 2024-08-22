package org.exam.deuxmainspourtoiapi.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "espace_detente")
public class EspaceDetente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false)
    private Integer id;

    @Column(name = "Titre", nullable = false, length = 128)
    private String titre;

    @Column(name = "DescriptionCourte", nullable = false)
    private String descriptionCourte;

    @Column(name = "Description", nullable = false, length = 2048)
    private String description;

    @Column(name = "image", length = 1024)
    private String image;

    @Column(name = "Rang", nullable = false)
    private Integer rang;

}
