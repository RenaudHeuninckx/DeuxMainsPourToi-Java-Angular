package org.exam.deuxmainspourtoiapi.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EvenementContentDto {

    public EvenementContentDto() {
    }

    private Integer id;
    private EvenementDto evenement;
    private String description;
    private String image;
    private Integer rang;
}
