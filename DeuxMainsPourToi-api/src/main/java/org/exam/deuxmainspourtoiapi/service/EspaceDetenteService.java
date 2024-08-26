package org.exam.deuxmainspourtoiapi.service;

import org.exam.deuxmainspourtoiapi.dto.EspaceDetenteDto;

import java.util.List;

public interface EspaceDetenteService {
    EspaceDetenteDto createEspaceDetenteDto(EspaceDetenteDto espaceDetenteDto);
    EspaceDetenteDto updateEspaceDetenteDto(EspaceDetenteDto espaceDetenteDto);
    EspaceDetenteDto getEspaceDetenteDtoById(int id);
    List<EspaceDetenteDto> getAllEspaceDetenteDto();
    boolean deleteEspaceDetenteDtoById(int id);
}
