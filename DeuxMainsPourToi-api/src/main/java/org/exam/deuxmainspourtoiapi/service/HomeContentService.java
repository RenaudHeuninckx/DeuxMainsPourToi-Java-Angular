package org.exam.deuxmainspourtoiapi.service;

import org.exam.deuxmainspourtoiapi.dto.HomeContentDto;

import java.util.List;

public interface HomeContentService {
    HomeContentDto createHomeContentDto(HomeContentDto homeContentDto);
    HomeContentDto updateHomeContentDto(HomeContentDto homeContentDto);
    HomeContentDto getHomeContentDtoById(int id);
    List<HomeContentDto> getAllHomeContentDto();
    boolean deleteHomeContentDtoById(int id);
}
