package org.exam.deuxmainspourtoiapi.service;

import org.exam.deuxmainspourtoiapi.dto.EvenementDto;

import java.util.List;

public interface EvenementService {
    EvenementDto createEvenementDto(EvenementDto evenementDto);
    EvenementDto updateEvenementDto(EvenementDto evenementDto);
    EvenementDto getEvenementDtoById(int id);
    List<EvenementDto> getAllEvenementDto();
    boolean deleteEvenementDtoById(int id);
}
