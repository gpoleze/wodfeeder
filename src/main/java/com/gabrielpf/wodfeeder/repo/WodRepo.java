package com.gabrielpf.wodfeeder.repo;

import com.gabrielpf.wodfeeder.model.WOD;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface WodRepo extends CrudRepository<WOD, Long> {

    WOD findAllByDate(LocalDate date);
}