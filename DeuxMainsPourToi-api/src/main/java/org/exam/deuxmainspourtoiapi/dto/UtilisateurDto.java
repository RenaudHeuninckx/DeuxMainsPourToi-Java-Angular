package org.exam.deuxmainspourtoiapi.dto;

import lombok.Getter;
import lombok.Setter;

import java.security.Principal;
import java.time.LocalDate;

@Getter
@Setter
public class UtilisateurDto implements Principal {

    public UtilisateurDto() {
    }

    private Integer id;
    private String pseudo;
    private String email;
    private String password;
    private Boolean newsletter;
    private Boolean admin;
    private LocalDate createdDate;
    private LocalDate modifiedDate;
    private LocalDate deletedDate;

    @Override
    public String getName() {
        return this.email;
    }
}
