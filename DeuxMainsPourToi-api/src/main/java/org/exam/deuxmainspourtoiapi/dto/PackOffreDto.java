package org.exam.deuxmainspourtoiapi.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Set;

@Getter
@Setter
public class PackOffreDto {

    public PackOffreDto() {
    }

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
