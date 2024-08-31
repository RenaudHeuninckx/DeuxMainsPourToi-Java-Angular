package org.exam.deuxmainspourtoiapi.repository;

import org.exam.deuxmainspourtoiapi.entity.Comment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CommentRepository extends CrudRepository<Comment, Integer> {
    List<Comment> findByMassageId(int MassageId);
}
