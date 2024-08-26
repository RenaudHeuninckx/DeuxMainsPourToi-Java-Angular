package org.exam.deuxmainspourtoiapi.service;

import org.exam.deuxmainspourtoiapi.dto.CommentDto;

import java.util.List;

public interface CommentService {
    CommentDto createCommentDto(CommentDto commentDto);
    CommentDto updateCommentDto(CommentDto commentDto);
    CommentDto getCommentDtoById(int id);
    List<CommentDto> getAllCommentDto();
    boolean deleteCommentDtoById(int id);
}
