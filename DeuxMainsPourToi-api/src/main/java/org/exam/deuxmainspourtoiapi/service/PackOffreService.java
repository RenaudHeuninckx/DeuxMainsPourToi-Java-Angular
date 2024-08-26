package org.exam.deuxmainspourtoiapi.service;

import org.exam.deuxmainspourtoiapi.dto.PackOffreDto;

import java.util.List;

public interface PackOffreService {
    PackOffreDto createPackOffreDto(PackOffreDto packOffreDto);
    PackOffreDto updatePackOffreDto(PackOffreDto packOffreDto);
    PackOffreDto getPackOffreDtoById(int id);
    List<PackOffreDto> getAllPackOffreDto();
    boolean deletePackOffreDtoById(int id);
}
