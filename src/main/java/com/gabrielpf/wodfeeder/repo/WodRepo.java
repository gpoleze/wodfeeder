package com.gabrielpf.wodfeeder.repo;

import com.gabrielpf.wodfeeder.model.WOD;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface WodRepo extends CrudRepository<WOD, Long> {

    WOD findAllByDate(LocalDate date);

	@Query("SELECT DISTINCT w.week FROM WOD w ORDER BY w.week ASC")
    List<Integer> getAllDistinctWeeks();

	@Query("SELECT DISTINCT w.date FROM WOD w ORDER BY w.date ASC")
	List<LocalDate> getAllDistinctDates();

	List<WOD> findAllByWeek(int week);
}