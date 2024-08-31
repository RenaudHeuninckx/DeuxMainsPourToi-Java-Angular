package org.exam.deuxmainspourtoiapi.controller;

import org.exam.deuxmainspourtoiapi.dto.ActualiteDto;
import org.exam.deuxmainspourtoiapi.service.ActualiteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/actualite")
public class ActualiteController {

    @Autowired
    ActualiteServiceImpl actualiteServiceImpl;

    @PostMapping("/admin/create")
    public ResponseEntity<ActualiteDto> createActualite(@RequestBody ActualiteDto actualiteDto) {
        actualiteDto = actualiteServiceImpl.createActualiteDto(actualiteDto);
        return ResponseEntity.ok().body(actualiteDto);
    }

    @PutMapping("/admin/update")
    public ResponseEntity<ActualiteDto> updateActualite(@RequestBody ActualiteDto actualiteDto) {
        actualiteDto = actualiteServiceImpl.updateActualiteDto(actualiteDto);
        return ResponseEntity.ok().body(actualiteDto);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<ActualiteDto> getActualiteById(@PathVariable int id) {
        ActualiteDto actualiteDto = actualiteServiceImpl.getActualiteDtoById(id);
        return ResponseEntity.ok().body(actualiteDto);
    }

    @GetMapping("/")
    public ResponseEntity<List<ActualiteDto>> getAllActualites() {
        List<ActualiteDto> actualiteDtos = actualiteServiceImpl.getAllActualiteDto();
        return ResponseEntity.ok().body(actualiteDtos);
    }

    @DeleteMapping("/admin/delete/{id}")
    public ResponseEntity<String> deleteActualiteById(@PathVariable int id) {
        boolean deleted = actualiteServiceImpl.deleteActualiteDtoById(id);
        if (deleted) {
            return ResponseEntity.ok().body("Actualite " + id + " deleted");
        } else {
            return ResponseEntity.badRequest().body("Actualite " + id + " delete failed");
        }
    }
}
