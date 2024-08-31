package org.exam.deuxmainspourtoiapi.controller;

import org.exam.deuxmainspourtoiapi.dto.PresseDto;
import org.exam.deuxmainspourtoiapi.service.PresseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/presse")
public class PresseController {

    @Autowired
    PresseServiceImpl presseServiceImpl;

    @PostMapping("/admin/create")
    public ResponseEntity<PresseDto> createPresse(@RequestBody PresseDto presseDto) {
        presseDto = presseServiceImpl.createPresseDto(presseDto);
        return ResponseEntity.ok().body(presseDto);
    }

    @PutMapping("/admin/update")
    public ResponseEntity<PresseDto> updatePresse(@RequestBody PresseDto presseDto) {
        presseDto = presseServiceImpl.updatePresseDto(presseDto);
        return ResponseEntity.ok().body(presseDto);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<PresseDto> getPresse(@PathVariable int id) {
        PresseDto presseDto = presseServiceImpl.getPresseDtoById(id);
        return ResponseEntity.ok().body(presseDto);
    }

    @GetMapping("/")
    public ResponseEntity<List<PresseDto>> getAllPresse() {
        List<PresseDto> presseDtos = presseServiceImpl.getAllPresseDto();
        return ResponseEntity.ok().body(presseDtos);
    }

    @DeleteMapping("/admin/delete/{id}")
    public ResponseEntity<String> deletePresse(@PathVariable int id) {
        boolean deleted = presseServiceImpl.deletePresseDtoById(id);
        if (deleted) {
            return ResponseEntity.ok().body("Presse " + id + " deleted");
        } else {
            return ResponseEntity.badRequest().body("Presse " + id + " delete failed");
        }
    }
}
