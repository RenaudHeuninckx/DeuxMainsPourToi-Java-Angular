package org.exam.deuxmainspourtoiapi.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ActualiteContentDto {
    private Integer id;
    private ActualiteDto actualite;
    private String description;
    private String image;
    private Integer rang;
}
