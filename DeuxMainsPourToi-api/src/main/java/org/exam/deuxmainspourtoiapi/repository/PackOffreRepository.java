package org.exam.deuxmainspourtoiapi.repository;

import org.exam.deuxmainspourtoiapi.entity.PackOffre;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PackOffreRepository extends CrudRepository<PackOffre, Integer> {
}
