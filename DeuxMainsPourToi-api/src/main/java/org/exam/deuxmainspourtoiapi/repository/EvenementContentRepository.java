package org.exam.deuxmainspourtoiapi.repository;

import org.exam.deuxmainspourtoiapi.entity.EvenementContent;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EvenementContentRepository extends CrudRepository<EvenementContent, Integer> {
}
