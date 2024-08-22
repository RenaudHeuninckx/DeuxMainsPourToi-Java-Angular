package org.exam.deuxmainspourtoiapi.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Set;

@Data
public class PackOffreDto {
    private Integer id;
    private String titre;
    private String descriptionCourte;
    private String description;
    private BigDecimal prix;
    private String image;
    private Integer rang;
    private Boolean displayed = false;
    private Set<CommentDto> comments;
}
