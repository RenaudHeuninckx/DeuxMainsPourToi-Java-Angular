package org.exam.deuxmainspourtoiapi.controller;

import org.exam.deuxmainspourtoiapi.dto.ActualiteDto;
import org.exam.deuxmainspourtoiapi.entity.Actualite;
import org.exam.deuxmainspourtoiapi.service.ActualiteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/actualite")
public class ActualiteController {

    @Autowired
    ActualiteServiceImpl actualiteServiceImpl;

    @PostMapping("/create")
    public ResponseEntity<ActualiteDto> createActualite(@RequestBody ActualiteDto actualiteDto) {
        actualiteDto = actualiteServiceImpl.createActualite(actualiteDto);
        return ResponseEntity.ok().body(actualiteDto);
    }

    @PutMapping("/update")
    public ResponseEntity<ActualiteDto> updateActualite(@RequestBody ActualiteDto actualiteDto) {
        actualiteDto = actualiteServiceImpl.updateActualite(actualiteDto);
        return ResponseEntity.ok().body(actualiteDto);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<ActualiteDto> getActualiteById(@PathVariable int id) {
        ActualiteDto actualiteDto = actualiteServiceImpl.getActualiteDto(id);
        return ResponseEntity.ok().body(actualiteDto);
    }

    @GetMapping("/")
    public ResponseEntity<List<ActualiteDto>> getAllActualites() {
        List<ActualiteDto> actualiteDtos = actualiteServiceImpl.getAllActualiteDtos();
        return ResponseEntity.ok().body(actualiteDtos);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteActualiteById(@PathVariable int id) {
        boolean deleted = actualiteServiceImpl.deleteActualite(id);
        if (deleted) {
            return ResponseEntity.ok().body("Actualite " + id + " deleted");
        } else {
            return ResponseEntity.badRequest().body("Actualite " + id + " delete error");
        }
    }
}
