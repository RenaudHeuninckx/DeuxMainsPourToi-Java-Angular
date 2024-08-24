package org.exam.deuxmainspourtoiapi.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EspaceDetenteDto {

    public EspaceDetenteDto() {
    }

    private Integer id;
    private String titre;
    private String descriptionCourte;
    private String description;
    private String image;
    private Integer rang;
}
