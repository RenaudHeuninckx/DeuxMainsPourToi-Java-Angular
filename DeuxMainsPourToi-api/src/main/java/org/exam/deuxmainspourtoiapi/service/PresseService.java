package org.exam.deuxmainspourtoiapi.service;

import org.exam.deuxmainspourtoiapi.dto.PresseDto;

import java.util.List;

public interface PresseService {
    PresseDto createPresseDto(PresseDto presseDto);
    PresseDto updatePresseDto(PresseDto presseDto);
    PresseDto getPresseDtoById(int id);
    List<PresseDto> getAllPresseDto();
    boolean deletePresseDtoById(int id);
}
