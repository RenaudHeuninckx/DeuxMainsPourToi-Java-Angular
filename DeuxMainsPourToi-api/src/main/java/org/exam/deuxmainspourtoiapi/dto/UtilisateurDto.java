package org.exam.deuxmainspourtoiapi.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class UtilisateurDto {
    private Integer id;
    private String pseudo;
    private String email;
    private Boolean newsletter;
    private Boolean admin;
    private LocalDate createdDate;
    private LocalDate modifiedDate;
    private LocalDate deletedDate;
}
