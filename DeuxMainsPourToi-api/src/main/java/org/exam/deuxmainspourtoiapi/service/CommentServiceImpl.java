package org.exam.deuxmainspourtoiapi.service;

import org.exam.deuxmainspourtoiapi.dto.CommentDto;
import org.exam.deuxmainspourtoiapi.entity.Comment;
import org.exam.deuxmainspourtoiapi.repository.CommentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentRepository commentRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public CommentDto createCommentDto(CommentDto commentDto) {
        Comment comment = modelMapper.map(commentDto, Comment.class);
        comment = commentRepository.save(comment);
        return modelMapper.map(comment, CommentDto.class);
    }

    @Override
    public CommentDto updateCommentDto(CommentDto commentDto) {
        Comment comment = modelMapper.map(commentDto, Comment.class);
        comment = commentRepository.save(comment);
        return modelMapper.map(comment, CommentDto.class);
    }

    @Override
    public CommentDto getCommentDtoById(int id) {
        Comment comment = commentRepository.findById(id).orElse(null);
        return modelMapper.map(comment, CommentDto.class);
    }

    @Override
    public List<CommentDto> getAllCommentDto() {
        Iterable<Comment> comments = commentRepository.findAll();
        return StreamSupport
                .stream(comments.spliterator(),false)
                .map(c-> modelMapper.map(c, CommentDto.class))
                .toList();
    }

    @Override
    public List<CommentDto> getCommentDtoByMassageId(int massageId) {
        Iterable<Comment> comments = commentRepository.findByMassageId(massageId);
        return StreamSupport
                .stream(comments.spliterator(),false)
                .map(c-> modelMapper.map(c, CommentDto.class))
                .toList();
    }

    @Override
    public boolean deleteCommentDtoById(int id) {
        try {
            commentRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
