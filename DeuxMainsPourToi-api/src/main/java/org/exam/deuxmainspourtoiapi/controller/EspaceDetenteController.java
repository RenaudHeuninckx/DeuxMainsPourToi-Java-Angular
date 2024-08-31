package org.exam.deuxmainspourtoiapi.controller;

import org.exam.deuxmainspourtoiapi.dto.EspaceDetenteDto;
import org.exam.deuxmainspourtoiapi.service.EspaceDetenteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/espacedetente")
public class EspaceDetenteController {

    @Autowired
    EspaceDetenteServiceImpl espaceDetenteServiceImpl;

    @PostMapping("/admin/create")
    public ResponseEntity<EspaceDetenteDto> createEspaceDetente(@RequestBody EspaceDetenteDto espaceDetenteDto) {
        espaceDetenteDto = espaceDetenteServiceImpl.createEspaceDetenteDto(espaceDetenteDto);
        return ResponseEntity.ok().body(espaceDetenteDto);
    }

    @PutMapping("/admin/update")
    public ResponseEntity<EspaceDetenteDto> updateEspaceDetente(@RequestBody EspaceDetenteDto espaceDetenteDto) {
        espaceDetenteDto = espaceDetenteServiceImpl.updateEspaceDetenteDto(espaceDetenteDto);
        return ResponseEntity.ok().body(espaceDetenteDto);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<EspaceDetenteDto> getEspaceDetente(@PathVariable int id) {
        EspaceDetenteDto espaceDetenteDto = espaceDetenteServiceImpl.getEspaceDetenteDtoById(id);
        return ResponseEntity.ok().body(espaceDetenteDto);
    }

    @GetMapping("/")
    public ResponseEntity<List<EspaceDetenteDto>> getAllEspaceDetente() {
        List<EspaceDetenteDto> espaceDetenteDtos = espaceDetenteServiceImpl.getAllEspaceDetenteDto();
        return ResponseEntity.ok().body(espaceDetenteDtos);
    }

    @DeleteMapping("/admin/delete/{id}")
    public ResponseEntity<String> deleteEspaceDetente(@PathVariable int id) {
        boolean deleted = espaceDetenteServiceImpl.deleteEspaceDetenteDtoById(id);
        if (deleted) {
            return ResponseEntity.ok().body("EspaceDetente " + id + " deleted");
        } else {
            return ResponseEntity.badRequest().body("EspaceDetente " + id + " delete failed");
        }
    }
}
