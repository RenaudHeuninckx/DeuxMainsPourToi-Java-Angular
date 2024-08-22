package org.exam.deuxmainspourtoiapi.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class HomeContentDto {
    private Integer id;
    private String categorie;
    private Integer contentId;
    private LocalDate fromDate;
    private LocalDate toDate;
    private Integer rang;
}
