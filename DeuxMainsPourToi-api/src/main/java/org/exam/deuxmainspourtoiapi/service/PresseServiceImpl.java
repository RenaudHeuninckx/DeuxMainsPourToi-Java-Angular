package org.exam.deuxmainspourtoiapi.service;

import org.exam.deuxmainspourtoiapi.dto.PresseDto;
import org.exam.deuxmainspourtoiapi.entity.Presse;
import org.exam.deuxmainspourtoiapi.repository.PresseRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.StreamSupport;

@Service
public class PresseServiceImpl implements PresseService {

    @Autowired
    PresseRepository presseRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public PresseDto createPresseDto(PresseDto presseDto) {
        Presse presse = modelMapper.map(presseDto, Presse.class);
        presse = presseRepository.save(presse);
        return modelMapper.map(presse, PresseDto.class);
    }

    @Override
    public PresseDto updatePresseDto(PresseDto presseDto) {
        Presse presse = modelMapper.map(presseDto, Presse.class);
        presse = presseRepository.save(presse);
        return modelMapper.map(presse, PresseDto.class);
    }

    @Override
    public PresseDto getPresseDtoById(int id) {
        Presse presse = presseRepository.findById(id).orElse(null);
        return modelMapper.map(presse, PresseDto.class);
    }

    @Override
    public List<PresseDto> getAllPresseDto() {
        Iterable<Presse> presses = presseRepository.findAll();
        return StreamSupport
                .stream(presses.spliterator(),false)
                .map(p -> modelMapper.map(p, PresseDto.class))
                .toList();
    }

    @Override
    public boolean deletePresseDtoById(int id) {
        try {
            presseRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
