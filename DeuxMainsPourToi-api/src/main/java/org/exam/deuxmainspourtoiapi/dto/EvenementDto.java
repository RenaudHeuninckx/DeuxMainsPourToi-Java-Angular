package org.exam.deuxmainspourtoiapi.dto;

import lombok.Data;

import java.util.Set;

@Data
public class EvenementDto {
    private Integer id;
    private String titre;
    private String descriptionCourte;
    private Integer rang;
    private Boolean displayed;
    private Set<CommentDto> comments;
    private Set<EvenementContentDto> EvenementContents;
}
