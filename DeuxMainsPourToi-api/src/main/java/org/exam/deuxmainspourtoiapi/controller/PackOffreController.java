package org.exam.deuxmainspourtoiapi.controller;

import org.exam.deuxmainspourtoiapi.dto.PackOffreDto;
import org.exam.deuxmainspourtoiapi.service.PackOffreServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/packoffre")
public class PackOffreController {

    @Autowired
    PackOffreServiceImpl packOffreServiceImpl;

    @PostMapping("/admin/create")
    public ResponseEntity<PackOffreDto> createPackOffre(@RequestBody PackOffreDto packOffreDto) {
        packOffreDto = packOffreServiceImpl.createPackOffreDto(packOffreDto);
        return ResponseEntity.ok().body(packOffreDto);
    }

    @PutMapping("/admin/update")
    public ResponseEntity<PackOffreDto> updatePackOffre(@RequestBody PackOffreDto packOffreDto) {
        packOffreDto = packOffreServiceImpl.updatePackOffreDto(packOffreDto);
        return ResponseEntity.ok().body(packOffreDto);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<PackOffreDto> getPackOffreById(@PathVariable int id) {
        PackOffreDto packOffreDto = packOffreServiceImpl.getPackOffreDtoById(id);
        return ResponseEntity.ok().body(packOffreDto);
    }

    @GetMapping("/")
    public ResponseEntity<List<PackOffreDto>> getAllPackOffre() {
        List<PackOffreDto> packOffreDtos = packOffreServiceImpl.getAllPackOffreDto();
        return ResponseEntity.ok().body(packOffreDtos);
    }

    @DeleteMapping("/admin/delete/{id}")
    public ResponseEntity<String> deletePackOffreById(@PathVariable int id) {
        boolean deleted = packOffreServiceImpl.deletePackOffreDtoById(id);
        if (deleted) {
            return ResponseEntity.ok().body("PackOffre " + id + " deleted");
        } else {
            return ResponseEntity.badRequest().body("PackOffre " + id + " delete failed");
        }
    }
}
