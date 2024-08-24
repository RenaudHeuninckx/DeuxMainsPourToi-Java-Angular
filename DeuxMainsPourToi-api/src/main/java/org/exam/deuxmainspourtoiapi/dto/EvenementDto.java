package org.exam.deuxmainspourtoiapi.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class EvenementDto {

    public EvenementDto() {
    }

    private Integer id;
    private String titre;
    private String descriptionCourte;
    private Integer rang;
    private Boolean displayed;
    private Set<CommentDto> comments;
    private Set<EvenementContentDto> EvenementContents;
}
