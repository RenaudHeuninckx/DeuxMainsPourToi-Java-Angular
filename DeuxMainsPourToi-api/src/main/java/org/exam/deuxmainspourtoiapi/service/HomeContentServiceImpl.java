package org.exam.deuxmainspourtoiapi.service;

import org.exam.deuxmainspourtoiapi.dto.HomeContentDto;
import org.exam.deuxmainspourtoiapi.entity.HomeContent;
import org.exam.deuxmainspourtoiapi.repository.HomeContentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.StreamSupport;

@Service
public class HomeContentServiceImpl implements HomeContentService {

    @Autowired
    private HomeContentRepository homeContentRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public HomeContentDto createHomeContentDto(HomeContentDto homeContentDto) {
        HomeContent homeContent = modelMapper.map(homeContentDto, HomeContent.class);
        homeContentRepository.save(homeContent);
        return modelMapper.map(homeContent, HomeContentDto.class);
    }

    @Override
    public HomeContentDto updateHomeContentDto(HomeContentDto homeContentDto) {
        HomeContent homeContent = modelMapper.map(homeContentDto, HomeContent.class);
        homeContentRepository.save(homeContent);
        return modelMapper.map(homeContent, HomeContentDto.class);
    }

    @Override
    public HomeContentDto getHomeContentDtoById(int id) {
        HomeContent homeContent = homeContentRepository.findById(id).orElse(null);
        return modelMapper.map(homeContent, HomeContentDto.class);
    }

    @Override
    public List<HomeContentDto> getAllHomeContentDto() {
        Iterable<HomeContent> homeContents = homeContentRepository.findAll();
        return StreamSupport
                .stream(homeContents.spliterator(), false)
                .map(hc -> modelMapper.map(hc, HomeContentDto.class))
                .toList();
    }

    @Override
    public boolean deleteHomeContentDtoById(int id) {
        try {
            homeContentRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
