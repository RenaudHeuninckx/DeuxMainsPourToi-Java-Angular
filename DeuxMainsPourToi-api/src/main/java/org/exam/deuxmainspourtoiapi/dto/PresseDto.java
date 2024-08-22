package org.exam.deuxmainspourtoiapi.dto;

import lombok.Data;

@Data
public class PresseDto {
    private Integer id;
    private String titre;
    private String descriptionCourte;
    private String url;
    private Integer rang;
    private Boolean displayed;
}
