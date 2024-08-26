package org.exam.deuxmainspourtoiapi.service;

import org.exam.deuxmainspourtoiapi.dto.MassageDto;

import java.util.List;

public interface MassageService {
    MassageDto createMassageDto(MassageDto massageDto);
    MassageDto updateMassageDto(MassageDto massageDto);
    MassageDto getMassageDtoById(int id);
    List<MassageDto> getAllMassageDto();
    boolean deleteMassageDtoById(int id);
}
