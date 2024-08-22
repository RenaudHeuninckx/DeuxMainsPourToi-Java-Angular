package org.exam.deuxmainspourtoiapi.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "presse")
public class Presse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false)
    private Integer id;

    @Column(name = "Titre", nullable = false, length = 128)
    private String titre;

    @Column(name = "DescriptionCourte", nullable = false)
    private String descriptionCourte;

    @Column(name = "URL", length = 1024)
    private String url;

    @Column(name = "Rang", nullable = false)
    private Integer rang;

    @Column(name = "Displayed", nullable = false)
    private Boolean displayed;

}
