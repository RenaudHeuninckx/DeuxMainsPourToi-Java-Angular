package org.exam.deuxmainspourtoiapi.dto;

import lombok.Data;

@Data
public class EspaceDetenteDto {
    private Integer id;
    private String titre;
    private String descriptionCourte;
    private String description;
    private String image;
    private Integer rang;
}
