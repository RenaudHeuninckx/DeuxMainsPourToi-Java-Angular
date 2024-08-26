package org.exam.deuxmainspourtoiapi.service;

import org.exam.deuxmainspourtoiapi.dto.EvenementContentDto;

import java.util.List;

public interface EvenementContentService {
    EvenementContentDto createEvenementContentDto(EvenementContentDto evenementContentDto);
    EvenementContentDto updateEvenementContentDto(EvenementContentDto evenementContentDto);
    EvenementContentDto getEvenementContentDtoById(int id);
    List<EvenementContentDto> getAllEvenementContentDto();
    boolean deleteEvenementContentDtoById(int id);
}
