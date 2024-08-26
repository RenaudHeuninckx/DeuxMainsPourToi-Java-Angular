package org.exam.deuxmainspourtoiapi.service;

import org.exam.deuxmainspourtoiapi.dto.UtilisateurDto;

import java.util.List;

public interface UtilisateurService {
    UtilisateurDto createUtilisateurDto(UtilisateurDto utilisateurDto);
    UtilisateurDto updateUtilisateurDto(UtilisateurDto utilisateurDto);
    UtilisateurDto getUtilisateurDtoById(int id);
    List<UtilisateurDto> getAllUtilisateurDto();
    boolean deleteUtilisateurDtoById(int id);
}
