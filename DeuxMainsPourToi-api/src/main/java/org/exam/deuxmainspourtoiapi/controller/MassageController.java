package org.exam.deuxmainspourtoiapi.controller;

import org.exam.deuxmainspourtoiapi.dto.MassageDto;
import org.exam.deuxmainspourtoiapi.service.MassageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/massage")
public class MassageController {

    @Autowired
    MassageServiceImpl massageServiceImpl;

    @PostMapping("/admin/create")
    ResponseEntity<MassageDto> createMassageDto(@RequestBody MassageDto massageDto) {
        massageDto = massageServiceImpl.createMassageDto(massageDto);
        return ResponseEntity.ok().body(massageDto);
    }

    @PutMapping("/admin/update")
    ResponseEntity<MassageDto> updateMassageDto(@RequestBody MassageDto massageDto) {
        massageDto = massageServiceImpl.updateMassageDto(massageDto);
        return ResponseEntity.ok().body(massageDto);
    }

    @GetMapping("/get/{id}")
    ResponseEntity<MassageDto> getMassageDtoById(@PathVariable("id") int id) {
        MassageDto massageDto = massageServiceImpl.getMassageDtoById(id);
        return ResponseEntity.ok().body(massageDto);
    }

    @GetMapping("/")
    ResponseEntity<List<MassageDto>> getAllMassageDto() {
        List<MassageDto> massageDto = massageServiceImpl.getAllMassageDto();
        return ResponseEntity.ok().body(massageDto);
    }

    @DeleteMapping("/admin/delete/{id}")
    ResponseEntity<String> deleteMassageDtoById(@PathVariable("id") int id) {
        boolean deleted = massageServiceImpl.deleteMassageDtoById(id);
        if (deleted) {
            return ResponseEntity.ok().body("Massage " + id + " deleted");
        } else {
            return ResponseEntity.badRequest().body("Massage " + id + " delete failed");
        }
    }
}
