package org.exam.deuxmainspourtoiapi.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class ActualiteDto {

    public ActualiteDto() {
    }

    private int id;
    private String titre;
    private String descriptionCourte;
    private String url;
    private Boolean uRLonly;
    private Integer rang;
    private Boolean displayed;
    private Set<ActualiteContentDto> actualiteContents;
    private Set<CommentDto> comments;
}
