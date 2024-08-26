package org.exam.deuxmainspourtoiapi.controller;

import org.exam.deuxmainspourtoiapi.dto.ActualiteContentDto;
import org.exam.deuxmainspourtoiapi.service.ActualiteContentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/actualitecontent")
public class ActualiteContentController {

    @Autowired
    ActualiteContentServiceImpl actualiteContentServiceImpl;

    @PostMapping("/create")
    public ResponseEntity<ActualiteContentDto> createActualiteContent(@RequestBody ActualiteContentDto actualiteContentDto) {
        actualiteContentDto = actualiteContentServiceImpl.createActualiteContentDto(actualiteContentDto);
        return ResponseEntity.ok().body(actualiteContentDto);
    }

    @PutMapping("/update")
    public ResponseEntity<ActualiteContentDto> updateActualiteContent(@RequestBody ActualiteContentDto actualiteContentDto) {
        actualiteContentDto = actualiteContentServiceImpl.updateActualiteContentDto(actualiteContentDto);
        return ResponseEntity.ok().body(actualiteContentDto);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<ActualiteContentDto> getActualiteContentById(@PathVariable("id") int id) {
        ActualiteContentDto actualiteContentDto = actualiteContentServiceImpl.getActualiteContentDtoById(id);
        return ResponseEntity.ok().body(actualiteContentDto);
    }

    @GetMapping("/")
    public ResponseEntity<List<ActualiteContentDto>> getAllActualiteContent() {
        List<ActualiteContentDto> actualiteContentDtos = actualiteContentServiceImpl.getAllActualiteContentDto();
        return ResponseEntity.ok().body(actualiteContentDtos);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteActualiteContentById(@PathVariable int id) {
        boolean deleted = actualiteContentServiceImpl.deleteActualiteContentDtoById(id);
        if (deleted) {
            return ResponseEntity.ok().body("ActualiteContent " + id + " deleted");
        } else {
            return ResponseEntity.badRequest().body("ActualiteContent" + id + " delete failed");
        }
    }

}
