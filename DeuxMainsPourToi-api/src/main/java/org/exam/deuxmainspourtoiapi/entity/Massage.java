package org.exam.deuxmainspourtoiapi.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Set;

@Data
@Entity
@Table(name = "massage")
public class Massage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false)
    private Integer id;

    @Column(name = "Titre", nullable = false, length = 128)
    private String titre;

    @Column(name = "Type", length = 50)
    private String type;

    @Column(name = "DescriptionCourte", nullable = false)
    private String descriptionCourte;

    @Column(name = "Description", nullable = false, length = 2048)
    private String description;

    @Column(name = "Duree", nullable = false, length = 20)
    private String duree;

    @Column(name = "Prix", nullable = false, precision = 5, scale = 2)
    private BigDecimal prix;

    @Column(name = "Image", length = 1024)
    private String image;

    @Column(name = "Displayed", nullable = false)
    private Boolean displayed = false;

    @Column(name = "Rang", nullable = false)
    private Integer rang;

    @OneToMany(mappedBy = "massage")
    private Set<Comment> comments;

}
