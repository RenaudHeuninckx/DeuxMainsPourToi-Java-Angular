package org.exam.deuxmainspourtoiapi.dto;

import lombok.Data;

@Data
public class EvenementContentDto {
    private Integer id;
    private EvenementDto evenement;
    private String description;
    private String image;
    private Integer rang;
}
