package org.exam.deuxmainspourtoiapi.service;

import org.exam.deuxmainspourtoiapi.dto.ActualiteDto;

import java.util.List;

public interface ActualiteService {
    ActualiteDto createActualiteDto(ActualiteDto actualiteDto);
    ActualiteDto updateActualiteDto(ActualiteDto actualiteDto);
    ActualiteDto getActualiteDtoById(int id);
    List<ActualiteDto> getAllActualiteDto();
    boolean deleteActualiteDtoById(int id);
}
