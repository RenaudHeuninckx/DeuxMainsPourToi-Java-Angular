package org.exam.deuxmainspourtoiapi.service;

import org.exam.deuxmainspourtoiapi.dto.ActualiteContentDto;

import java.util.List;

public interface ActualiteContentService {
    ActualiteContentDto createActualiteContentDto(ActualiteContentDto actualiteContentDto);
    ActualiteContentDto updateActualiteContentDto(ActualiteContentDto actualiteContentDto);
    ActualiteContentDto getActualiteContentDtoById(int id);
    List<ActualiteContentDto> getAllActualiteContentDto();
    boolean deleteActualiteContentDtoById(int id);
}
