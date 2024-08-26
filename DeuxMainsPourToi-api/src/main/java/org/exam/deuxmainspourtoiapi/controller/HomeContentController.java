package org.exam.deuxmainspourtoiapi.controller;

import org.exam.deuxmainspourtoiapi.dto.HomeContentDto;
import org.exam.deuxmainspourtoiapi.service.HomeContentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/homecontent")
public class HomeContentController {

    @Autowired
    HomeContentServiceImpl homeContentServiceImpl;

    @PostMapping("/create")
    public ResponseEntity<HomeContentDto> createHomeContent(@RequestBody HomeContentDto homeContentDto) {
        homeContentDto = homeContentServiceImpl.createHomeContentDto(homeContentDto);
        return ResponseEntity.ok().body(homeContentDto);
    }

    @PutMapping("/update")
    public ResponseEntity<HomeContentDto> updateHomeContent(@RequestBody HomeContentDto homeContentDto) {
        homeContentDto = homeContentServiceImpl.updateHomeContentDto(homeContentDto);
        return ResponseEntity.ok().body(homeContentDto);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<HomeContentDto> getHomeContent(@PathVariable int id) {
        HomeContentDto homeContentDto = homeContentServiceImpl.getHomeContentDtoById(id);
        return ResponseEntity.ok().body(homeContentDto);
    }

    @GetMapping("/")
    public ResponseEntity<List<HomeContentDto>> getAllHomeContent() {
        List<HomeContentDto> homeContentDtos = homeContentServiceImpl.getAllHomeContentDto();
        return ResponseEntity.ok().body(homeContentDtos);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteHomeContent(@PathVariable int id) {
        boolean deleted = homeContentServiceImpl.deleteHomeContentDtoById(id);
        if (deleted) {
            return ResponseEntity.ok().body("HomeContent " + id + " deleted");
        } else {
            return ResponseEntity.badRequest().body("HomeContent " + id + " delete failed");
        }
    }
}
