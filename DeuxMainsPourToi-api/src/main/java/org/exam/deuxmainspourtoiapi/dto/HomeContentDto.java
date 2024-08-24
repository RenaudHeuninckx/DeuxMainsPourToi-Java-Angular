package org.exam.deuxmainspourtoiapi.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class HomeContentDto {

    public HomeContentDto() {
    }

    private Integer id;
    private String categorie;
    private Integer contentId;
    private LocalDate fromDate;
    private LocalDate toDate;
    private Integer rang;
}
