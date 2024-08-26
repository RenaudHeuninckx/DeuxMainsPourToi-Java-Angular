package org.exam.deuxmainspourtoiapi.service;

import org.exam.deuxmainspourtoiapi.dto.EvenementContentDto;
import org.exam.deuxmainspourtoiapi.entity.EvenementContent;
import org.exam.deuxmainspourtoiapi.repository.EvenementContentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.StreamSupport;

@Service
public class EvenementContentServiceImpl implements EvenementContentService {

    @Autowired
    EvenementContentRepository evenementContentRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public EvenementContentDto createEvenementContentDto(EvenementContentDto evenementContentDto) {
        EvenementContent evenementContent = modelMapper.map(evenementContentDto, EvenementContent.class);
        evenementContent = evenementContentRepository.save(evenementContent);
        return modelMapper.map(evenementContent, EvenementContentDto.class);
    }

    @Override
    public EvenementContentDto updateEvenementContentDto(EvenementContentDto evenementContentDto) {
        EvenementContent evenementContent = modelMapper.map(evenementContentDto, EvenementContent.class);
        evenementContent = evenementContentRepository.save(evenementContent);
        return modelMapper.map(evenementContent, EvenementContentDto.class);
    }

    @Override
    public EvenementContentDto getEvenementContentDtoById(int id) {
        EvenementContent evenementContent = evenementContentRepository.findById(id).orElse(null);
        return modelMapper.map(evenementContent, EvenementContentDto.class);
    }

    @Override
    public List<EvenementContentDto> getAllEvenementContentDto() {
        Iterable<EvenementContent> evenementContents = evenementContentRepository.findAll();
        return StreamSupport
                .stream(evenementContents.spliterator(),false)
                .map(ec -> modelMapper.map(ec,EvenementContentDto.class))
                .toList();
    }

    @Override
    public boolean deleteEvenementContentDtoById(int id) {
        try {
            evenementContentRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
