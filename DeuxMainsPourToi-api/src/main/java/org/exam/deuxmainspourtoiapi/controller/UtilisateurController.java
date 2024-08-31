package org.exam.deuxmainspourtoiapi.controller;

import org.exam.deuxmainspourtoiapi.dto.UtilisateurDto;
import org.exam.deuxmainspourtoiapi.service.UtilisateurServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/utilisateur")
public class UtilisateurController {

    @Autowired
    UtilisateurServiceImpl utilisateurServiceImpl;

    @PostMapping("/create")
    public ResponseEntity<UtilisateurDto> createUtilisateur(@RequestBody UtilisateurDto utilisateurDto) {
        utilisateurDto = utilisateurServiceImpl.createUtilisateurDto(utilisateurDto);
        return ResponseEntity.ok().body(utilisateurDto);
    }

    @PutMapping("/update")
    public ResponseEntity<UtilisateurDto> updateUtilisateur(@RequestBody UtilisateurDto utilisateurDto) {
        utilisateurDto = utilisateurServiceImpl.updateUtilisateurDto(utilisateurDto);
        return ResponseEntity.ok().body(utilisateurDto);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<UtilisateurDto> getUtilisateurById(@PathVariable int id) {
        UtilisateurDto utilisateurDto = utilisateurServiceImpl.getUtilisateurDtoById(id);
        return ResponseEntity.ok().body(utilisateurDto);
    }

    @GetMapping("/")
    public ResponseEntity<List<UtilisateurDto>> getAllUtilisateur() {
        List<UtilisateurDto> utilisateurDtos = utilisateurServiceImpl.getAllUtilisateurDto();
        return ResponseEntity.ok().body(utilisateurDtos);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUtilisateur(@PathVariable int id) {
        boolean deleted = utilisateurServiceImpl.deleteUtilisateurDtoById(id);
        if (deleted) {
            return ResponseEntity.ok().body("Utilisateur " + id + " deleted");
        }else {
            return ResponseEntity.badRequest().body("Utilisateur " + id + " delete failed");
        }
    }

}
