package org.exam.deuxmainspourtoiapi.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@Builder
public class ActualiteDto {
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
