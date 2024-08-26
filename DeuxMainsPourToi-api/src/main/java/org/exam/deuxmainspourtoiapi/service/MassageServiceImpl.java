package org.exam.deuxmainspourtoiapi.service;

import org.exam.deuxmainspourtoiapi.dto.MassageDto;
import org.exam.deuxmainspourtoiapi.entity.Massage;
import org.exam.deuxmainspourtoiapi.repository.MassageRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.StreamSupport;

@Service
public class MassageServiceImpl implements MassageService {

    @Autowired
    MassageRepository massageRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public MassageDto createMassageDto(MassageDto massageDto) {
        Massage massage = modelMapper.map(massageDto, Massage.class);
        massage = massageRepository.save(massage);
        return modelMapper.map(massage, MassageDto.class);
    }

    @Override
    public MassageDto updateMassageDto(MassageDto massageDto) {
        Massage massage = modelMapper.map(massageDto, Massage.class);
        massage = massageRepository.save(massage);
        return modelMapper.map(massage, MassageDto.class);
    }

    @Override
    public MassageDto getMassageDtoById(int id) {
        Massage massage = massageRepository.findById(id).orElse(null);
        return modelMapper.map(massage, MassageDto.class);
    }

    @Override
    public List<MassageDto> getAllMassageDto() {
        Iterable<Massage> massages = massageRepository.findAll();
        return StreamSupport
                .stream(massages.spliterator(),false)
                .map(m -> modelMapper.map(m, MassageDto.class))
                .toList();
    }

    @Override
    public boolean deleteMassageDtoById(int id) {
        try {
            massageRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
