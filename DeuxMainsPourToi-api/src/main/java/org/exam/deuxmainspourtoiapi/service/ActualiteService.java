package org.exam.deuxmainspourtoiapi.service;

import org.exam.deuxmainspourtoiapi.dto.ActualiteDto;

import java.util.List;

public interface ActualiteService {
    ActualiteDto createActualite(ActualiteDto actualiteDto);
    ActualiteDto updateActualite(ActualiteDto actualiteDto);
    ActualiteDto getActualiteDto(int id);
    List<ActualiteDto> getAllActualiteDtos();
    void deleteActualite(int id);
}
