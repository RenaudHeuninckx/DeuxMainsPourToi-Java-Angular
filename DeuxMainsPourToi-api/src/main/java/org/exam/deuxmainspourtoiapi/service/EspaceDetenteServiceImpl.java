package org.exam.deuxmainspourtoiapi.service;

import org.exam.deuxmainspourtoiapi.dto.EspaceDetenteDto;
import org.exam.deuxmainspourtoiapi.entity.EspaceDetente;
import org.exam.deuxmainspourtoiapi.repository.EspaceDetenteRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.StreamSupport;

@Service
public class EspaceDetenteServiceImpl implements EspaceDetenteService{

    @Autowired
    EspaceDetenteRepository espaceDetenteRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public EspaceDetenteDto createEspaceDetenteDto(EspaceDetenteDto espaceDetenteDto) {
        EspaceDetente espaceDetente = modelMapper.map(espaceDetenteDto, EspaceDetente.class);
        espaceDetente = espaceDetenteRepository.save(espaceDetente);
        return modelMapper.map(espaceDetente, EspaceDetenteDto.class);
    }

    @Override
    public EspaceDetenteDto updateEspaceDetenteDto(EspaceDetenteDto espaceDetenteDto) {
        EspaceDetente espaceDetente = modelMapper.map(espaceDetenteDto, EspaceDetente.class);
        espaceDetente = espaceDetenteRepository.save(espaceDetente);
        return modelMapper.map(espaceDetente, EspaceDetenteDto.class);
    }

    @Override
    public EspaceDetenteDto getEspaceDetenteDtoById(int id) {
        EspaceDetente espaceDetente = espaceDetenteRepository.findById(id).orElse(null);
        return modelMapper.map(espaceDetente, EspaceDetenteDto.class);
    }

    @Override
    public List<EspaceDetenteDto> getAllEspaceDetenteDto() {
        Iterable<EspaceDetente> espaceDetentes = espaceDetenteRepository.findAll();
        return StreamSupport
                .stream(espaceDetentes.spliterator(),false)
                .map(ed -> modelMapper.map(ed, EspaceDetenteDto.class))
                .toList();
    }

    @Override
    public boolean deleteEspaceDetenteDtoById(int id) {
        try {
            espaceDetenteRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
