package org.exam.deuxmainspourtoiapi.repository;

import org.exam.deuxmainspourtoiapi.entity.Comment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends CrudRepository<Comment, Integer> {
}
