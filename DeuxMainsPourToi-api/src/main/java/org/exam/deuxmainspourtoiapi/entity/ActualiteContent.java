package org.exam.deuxmainspourtoiapi.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Data
@Entity
@Table(name = "actualite_content")
public class ActualiteContent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "ActualiteId", nullable = false)
    private Actualite actualite;

    @Column(name = "Description", nullable = false, length = 2048)
    private String description;

    @Column(name = "Image", length = 1024)
    private String image;

    @Column(name = "Rang", nullable = false)
    private Integer rang;

}
