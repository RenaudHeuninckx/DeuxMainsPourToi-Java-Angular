package org.exam.deuxmainspourtoiapi.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "utilisateur")
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false)
    private Integer id;

    @Column(name = "Pseudo", nullable = false)
    private String pseudo;

    @Column(name = "Email", nullable = false, length = 1024)
    private String email;

    @Column(name = "Newsletter", nullable = false)
    private Boolean newsletter;

    @Column(name = "Admin", nullable = false)
    private Boolean admin;

    @Column(name = "CreatedDate", nullable = false)
    private LocalDate createdDate;

    @Column(name = "ModifiedDate", nullable = false)
    private LocalDate modifiedDate;

    @Column(name = "DeletedDate")
    private LocalDate deletedDate;

}
