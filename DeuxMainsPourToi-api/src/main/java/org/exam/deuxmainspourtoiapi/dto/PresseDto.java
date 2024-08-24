package org.exam.deuxmainspourtoiapi.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PresseDto {

    public PresseDto() {
    }

    private Integer id;
    private String titre;
    private String descriptionCourte;
    private String url;
    private Integer rang;
    private Boolean displayed;
}
