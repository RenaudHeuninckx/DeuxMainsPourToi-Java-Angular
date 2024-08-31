package org.exam.deuxmainspourtoiapi.service;

import org.exam.deuxmainspourtoiapi.dto.UtilisateurDto;
import org.exam.deuxmainspourtoiapi.entity.Utilisateur;
import org.exam.deuxmainspourtoiapi.repository.UtilisateurRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.StreamSupport;

@Service
public class UtilisateurServiceImpl implements UtilisateurService{

    @Autowired
    UtilisateurRepository utilisateurRepository;

    @Autowired
    ModelMapper modelMapper;


    @Override
    public UtilisateurDto createUtilisateurDto(UtilisateurDto utilisateurDto) {
        Utilisateur utilisateur = modelMapper.map(utilisateurDto, Utilisateur.class);
        utilisateur.setCreatedDate(LocalDate.now());
        utilisateur.setModifiedDate(LocalDate.now());
        utilisateur = utilisateurRepository.save(utilisateur);
        return modelMapper.map(utilisateur, UtilisateurDto.class);
    }

    @Override
    public UtilisateurDto updateUtilisateurDto(UtilisateurDto utilisateurDto) {
        Utilisateur utilisateur = modelMapper.map(utilisateurDto, Utilisateur.class);
        utilisateur.setModifiedDate(LocalDate.now());
        utilisateur = utilisateurRepository.save(utilisateur);
        return modelMapper.map(utilisateur, UtilisateurDto.class);
    }

    @Override
    public UtilisateurDto getUtilisateurDtoById(int id) {
        Utilisateur utilisateur = utilisateurRepository.findById(id).orElse(null);
        return modelMapper.map(utilisateur, UtilisateurDto.class);
    }

    @Override
    public UtilisateurDto getUtilisateurDtoByEmail(String email) {
        Utilisateur utilisateur = utilisateurRepository.findByEmail(email).orElse(null);
        return modelMapper.map(utilisateur, UtilisateurDto.class);
    }

    @Override
    public boolean isEmailExist(String email) {
        Utilisateur utilisateur = utilisateurRepository.findByEmail(email).orElse(null);
        return !Objects.isNull(utilisateur);
    }

    @Override
    public boolean isPseudoExist(String pseudo) {
        Utilisateur utilisateur = utilisateurRepository.findByPseudo(pseudo).orElse(null);
        return !Objects.isNull(utilisateur);
    }

    @Override
    public List<UtilisateurDto> getAllUtilisateurDto() {
        Iterable<Utilisateur> utilisateurs = utilisateurRepository.findAll();
        return StreamSupport
                .stream(utilisateurs.spliterator(),false)
                .map(u -> modelMapper.map(u, UtilisateurDto.class))
                .toList();
    }

    @Override
    public boolean deleteUtilisateurDtoById(int id) {
        try {
            utilisateurRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
