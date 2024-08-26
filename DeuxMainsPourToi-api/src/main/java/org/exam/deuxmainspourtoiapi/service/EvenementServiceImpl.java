package org.exam.deuxmainspourtoiapi.service;

import org.exam.deuxmainspourtoiapi.dto.EvenementDto;
import org.exam.deuxmainspourtoiapi.entity.Evenement;
import org.exam.deuxmainspourtoiapi.repository.EvenementRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.StreamSupport;

@Service
public class EvenementServiceImpl implements EvenementService{

    @Autowired
    EvenementRepository evenementRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public EvenementDto createEvenementDto(EvenementDto evenementDto) {
        Evenement evenement = modelMapper.map(evenementDto, Evenement.class);
        evenement = evenementRepository.save(evenement);
        return modelMapper.map(evenement, EvenementDto.class);
    }

    @Override
    public EvenementDto updateEvenementDto(EvenementDto evenementDto) {
        Evenement evenement = modelMapper.map(evenementDto, Evenement.class);
        evenement = evenementRepository.save(evenement);
        return modelMapper.map(evenement, EvenementDto.class);
    }

    @Override
    public EvenementDto getEvenementDtoById(int id) {
        Evenement evenement = evenementRepository.findById(id).orElse(null);
        return modelMapper.map(evenement, EvenementDto.class);
    }

    @Override
    public List<EvenementDto> getAllEvenementDto() {
        Iterable<Evenement> evenements = evenementRepository.findAll();
        return StreamSupport
                .stream(evenements.spliterator(),false)
                .map(e -> modelMapper.map(e, EvenementDto.class))
                .toList();
    }

    @Override
    public boolean deleteEvenementDtoById(int id) {
        try {
            evenementRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
