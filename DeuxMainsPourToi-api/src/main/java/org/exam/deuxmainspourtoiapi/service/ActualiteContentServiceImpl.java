package org.exam.deuxmainspourtoiapi.service;

import org.exam.deuxmainspourtoiapi.dto.ActualiteContentDto;
import org.exam.deuxmainspourtoiapi.entity.ActualiteContent;
import org.exam.deuxmainspourtoiapi.repository.ActualiteContentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.StreamSupport;

@Service
public class ActualiteContentServiceImpl implements ActualiteContentService {

    @Autowired
    ActualiteContentRepository actualiteContentRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public ActualiteContentDto createActualiteContentDto(ActualiteContentDto actualiteContentDto) {
        ActualiteContent actualiteContent = modelMapper.map(actualiteContentDto, ActualiteContent.class);
        actualiteContent = actualiteContentRepository.save(actualiteContent);
        return modelMapper.map(actualiteContent, ActualiteContentDto.class);
    }

    @Override
    public ActualiteContentDto updateActualiteContentDto(ActualiteContentDto actualiteContentDto) {
        ActualiteContent actualiteContent = modelMapper.map(actualiteContentDto, ActualiteContent.class);
        actualiteContent = actualiteContentRepository.save(actualiteContent);
        return modelMapper.map(actualiteContent, ActualiteContentDto.class);
    }

    @Override
    public ActualiteContentDto getActualiteContentDtoById(int id) {
        ActualiteContent actualiteContent = actualiteContentRepository.findById(id).orElse(null);
        return modelMapper.map(actualiteContent, ActualiteContentDto.class);
    }

    @Override
    public List<ActualiteContentDto> getAllActualiteContentDto() {
        Iterable<ActualiteContent> actualiteContents = actualiteContentRepository.findAll();
        return StreamSupport
                .stream(actualiteContents.spliterator(), false)
                .map(ac -> modelMapper.map(ac, ActualiteContentDto.class))
                .toList();
    }

    @Override
    public boolean deleteActualiteContentDtoById(int id) {
        try {
            actualiteContentRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
