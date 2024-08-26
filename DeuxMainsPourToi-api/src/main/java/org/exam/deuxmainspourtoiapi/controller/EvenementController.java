package org.exam.deuxmainspourtoiapi.controller;

import org.exam.deuxmainspourtoiapi.dto.EvenementDto;
import org.exam.deuxmainspourtoiapi.service.EvenementServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/evenement")
public class EvenementController {

    @Autowired
    EvenementServiceImpl evenementServiceImpl;

    @PostMapping("/create")
    public ResponseEntity<EvenementDto> createEvenement(@RequestBody EvenementDto evenementDto) {
        evenementDto = evenementServiceImpl.createEvenementDto(evenementDto);
        return ResponseEntity.ok().body(evenementDto);
    }

    @PutMapping("/update")
    ResponseEntity<EvenementDto> updateEvenement(@RequestBody EvenementDto evenementDto) {
        evenementDto = evenementServiceImpl.updateEvenementDto(evenementDto);
        return ResponseEntity.ok().body(evenementDto);
    }

    @GetMapping("/get/{id}")
    ResponseEntity<EvenementDto> getEvenement(@PathVariable int id) {
        EvenementDto evenementDto = evenementServiceImpl.getEvenementDtoById(id);
        return ResponseEntity.ok().body(evenementDto);
    }

    @GetMapping("/")
    ResponseEntity<List<EvenementDto>> getAllEvenement() {
        List<EvenementDto> evenementDtos = evenementServiceImpl.getAllEvenementDto();
        return ResponseEntity.ok().body(evenementDtos);
    }

    @DeleteMapping("/delete/{id}")
    ResponseEntity<String> deleteEvenement(@PathVariable int id) {
        boolean deleted = evenementServiceImpl.deleteEvenementDtoById(id);
        if (deleted) {
            return ResponseEntity.ok().body("Evenement " + id + " deleted");
        } else {
            return ResponseEntity.badRequest().body("Evenement " + id + " delete failed");
        }
    }
}
