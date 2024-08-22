package org.exam.deuxmainspourtoiapi.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "homecontent")
public class HomeContent {
    @Id
    @Column(name = "Id", nullable = false)
    private Integer id;

    @Column(name = "Categorie", nullable = false, length = 50)
    private String categorie;

    @Column(name = "ContentId", nullable = false)
    private Integer contentId;

    @Column(name = "FromDate")
    private LocalDate fromDate;

    @Column(name = "ToDate")
    private LocalDate toDate;

    @Column(name = "Rang", nullable = false)
    private Integer rang;

}
