package org.exam.deuxmainspourtoiapi.service;

import org.exam.deuxmainspourtoiapi.dto.ActualiteDto;
import org.exam.deuxmainspourtoiapi.entity.Actualite;
import org.exam.deuxmainspourtoiapi.repository.ActualiteRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.StreamSupport;

@Service
public class ActualiteServiceImpl implements ActualiteService {

    @Autowired
    ActualiteRepository actualiteRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public ActualiteDto createActualiteDto(ActualiteDto actualiteDto) {
        Actualite actualite = modelMapper.map(actualiteDto, Actualite.class);
        actualite = actualiteRepository.save(actualite);
        return modelMapper.map(actualite, ActualiteDto.class);
    }

    @Override
    public ActualiteDto updateActualiteDto(ActualiteDto actualiteDto) {
        Actualite actualite = modelMapper.map(actualiteDto, Actualite.class);
        actualite = actualiteRepository.save(actualite);
        return modelMapper.map(actualite, ActualiteDto.class);
    }

    @Override
    public ActualiteDto getActualiteDtoById(int id) {
        Actualite actualite = actualiteRepository.findById(id).orElse(null);
        return modelMapper.map(actualite, ActualiteDto.class);
    }

    @Override
    public List<ActualiteDto> getAllActualiteDto() {
        Iterable<Actualite> actualites = actualiteRepository.findAll();
        return StreamSupport
                .stream(actualites.spliterator(),false)
                .map(a -> modelMapper.map(a,ActualiteDto.class))
                .toList();
    }

    @Override
    public boolean deleteActualiteDtoById(int id) {
        try {
            actualiteRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
