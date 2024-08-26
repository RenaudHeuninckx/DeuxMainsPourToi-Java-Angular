package org.exam.deuxmainspourtoiapi.controller;

import org.exam.deuxmainspourtoiapi.dto.EvenementContentDto;
import org.exam.deuxmainspourtoiapi.service.EvenementContentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/evenementcontent")
public class EvenementContentController {

    @Autowired
    private EvenementContentServiceImpl evenementContentServiceImpl;

    @PostMapping("/create")
    public ResponseEntity<EvenementContentDto> createEvenementContent(@RequestBody EvenementContentDto evenementContentDto) {
        evenementContentDto = evenementContentServiceImpl.createEvenementContentDto(evenementContentDto);
        return ResponseEntity.ok().body(evenementContentDto);
    }

    @PutMapping("/update")
    public ResponseEntity<EvenementContentDto> updateEvenementContent(@RequestBody EvenementContentDto evenementContentDto) {
        evenementContentDto = evenementContentServiceImpl.updateEvenementContentDto(evenementContentDto);
        return ResponseEntity.ok().body(evenementContentDto);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<EvenementContentDto> getEvenementContent(@PathVariable int id) {
        EvenementContentDto evenementContentDto = evenementContentServiceImpl.getEvenementContentDtoById(id);
        return ResponseEntity.ok().body(evenementContentDto);
    }

    @GetMapping("/")
    public ResponseEntity<List<EvenementContentDto>> getAllEvenementContent() {
        List<EvenementContentDto> evenementContentDtos = evenementContentServiceImpl.getAllEvenementContentDto();
        return ResponseEntity.ok().body(evenementContentDtos);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEvenementContent(@PathVariable int id) {
        boolean deleted = evenementContentServiceImpl.deleteEvenementContentDtoById(id);
        if (deleted) {
            return ResponseEntity.ok().body("EvenementContent " + id + " deleted");
        } else {
            return ResponseEntity.badRequest().body("EvenementContent " + id + " delete failed");
        }
    }
}
