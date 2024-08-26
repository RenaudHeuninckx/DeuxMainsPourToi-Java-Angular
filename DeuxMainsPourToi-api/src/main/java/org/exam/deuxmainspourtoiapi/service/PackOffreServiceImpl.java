package org.exam.deuxmainspourtoiapi.service;

import org.exam.deuxmainspourtoiapi.dto.PackOffreDto;
import org.exam.deuxmainspourtoiapi.entity.PackOffre;
import org.exam.deuxmainspourtoiapi.repository.PackOffreRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.StreamSupport;

@Service
public class PackOffreServiceImpl implements PackOffreService {

    @Autowired
    PackOffreRepository packOffreRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public PackOffreDto createPackOffreDto(PackOffreDto packOffreDto) {
        PackOffre packOffre = modelMapper.map(packOffreDto, PackOffre.class);
        packOffre = packOffreRepository.save(packOffre);
        return modelMapper.map(packOffre, PackOffreDto.class);
    }

    @Override
    public PackOffreDto updatePackOffreDto(PackOffreDto packOffreDto) {
        PackOffre packOffre = modelMapper.map(packOffreDto, PackOffre.class);
        packOffre = packOffreRepository.save(packOffre);
        return modelMapper.map(packOffre, PackOffreDto.class);
    }

    @Override
    public PackOffreDto getPackOffreDtoById(int id) {
        PackOffre packOffre = packOffreRepository.findById(id).orElse(null);
        return modelMapper.map(packOffre, PackOffreDto.class);
    }

    @Override
    public List<PackOffreDto> getAllPackOffreDto() {
        Iterable<PackOffre> packOffres = packOffreRepository.findAll();
        return StreamSupport
                .stream(packOffres.spliterator(), false)
                .map(po -> modelMapper.map(po, PackOffreDto.class))
                .toList();
    }

    @Override
    public boolean deletePackOffreDtoById(int id) {
        try {
            packOffreRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
