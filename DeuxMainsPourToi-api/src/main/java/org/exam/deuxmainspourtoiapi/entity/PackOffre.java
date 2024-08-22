package org.exam.deuxmainspourtoiapi.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Set;

@Data
@Entity
@Table(name = "pack_offre")
public class PackOffre {
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

    @Column(name = "prix", nullable = false, precision = 5, scale = 2)
    private BigDecimal prix;

    @Column(name = "Image", nullable = false, length = 1024)
    private String image;

    @Column(name = "Rang", nullable = false)
    private Integer rang;

    @Column(name = "Displayed", nullable = false)
    private Boolean displayed = false;

    @OneToMany(mappedBy = "packOffre")
    private Set<Comment> comments;

}
