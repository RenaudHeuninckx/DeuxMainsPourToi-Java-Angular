package org.exam.deuxmainspourtoiapi.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Set;

@Getter
@Setter
public class MassageDto {

    public MassageDto() {
    }

    private Integer id;
    private String titre;
    private String type;
    private String descriptionCourte;
    private String description;
    private String duree;
    private BigDecimal prix;
    private String image;
    private Boolean displayed;
    private Integer rang;
    private Set<CommentDto> comments;
}
