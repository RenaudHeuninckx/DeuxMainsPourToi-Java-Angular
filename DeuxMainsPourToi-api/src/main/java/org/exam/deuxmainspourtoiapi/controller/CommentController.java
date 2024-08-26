package org.exam.deuxmainspourtoiapi.controller;

import org.exam.deuxmainspourtoiapi.dto.CommentDto;
import org.exam.deuxmainspourtoiapi.service.CommentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comment")
public class CommentController {

    @Autowired
    CommentServiceImpl commentServiceImpl;

    @PostMapping("/create")
    public ResponseEntity<CommentDto> createComment(@RequestBody CommentDto commentDto) {
        commentDto = commentServiceImpl.createCommentDto(commentDto);
        return ResponseEntity.ok().body(commentDto);
    }

    @PutMapping("/update")
    public ResponseEntity<CommentDto> updateComment(@RequestBody CommentDto commentDto) {
        commentDto = commentServiceImpl.updateCommentDto(commentDto);
        return ResponseEntity.ok().body(commentDto);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<CommentDto> getCommentById(@PathVariable int id) {
        CommentDto commentDto = commentServiceImpl.getCommentDtoById(id);
        return ResponseEntity.ok().body(commentDto);
    }

    @GetMapping("/")
    public ResponseEntity<List<CommentDto>> getAllComments() {
        List<CommentDto> commentDtos = commentServiceImpl.getAllCommentDto();
        return ResponseEntity.ok().body(commentDtos);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteComment(@PathVariable int id) {
        boolean deleted = commentServiceImpl.deleteCommentDtoById(id);
        if (deleted) {
            return ResponseEntity.ok().body("Comment " + id + " deleted");
        } else {
            return ResponseEntity.badRequest().body("Comment " + id + " delete failed");
        }
    }
}
