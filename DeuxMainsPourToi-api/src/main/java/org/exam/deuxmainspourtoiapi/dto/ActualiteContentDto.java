package org.exam.deuxmainspourtoiapi.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ActualiteContentDto {

    public ActualiteContentDto() {
    }

    private Integer id;
    private ActualiteDto actualite;
    private String description;
    private String image;
    private Integer rang;
}
