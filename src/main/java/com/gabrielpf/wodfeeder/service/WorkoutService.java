package com.gabrielpf.wodfeeder.service;

import static java.util.stream.Collectors.toUnmodifiableList;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.gabrielpf.wodfeeder.repo.WorkoutRepo;
import com.gabrielpf.wodfeeder.vo.WorkoutVO;

@Service
public class WorkoutService {

    private final WorkoutRepo repo;

    public WorkoutService(WorkoutRepo repo) {this.repo = repo;}

    public List<WorkoutVO> findAllByDate(LocalDate date) {
        return repo.findByDate(date)
                .orElse(Collections.emptyList())
                .stream()
                .map(WorkoutVO::new)
                .collect(toUnmodifiableList());
    }

    public List<WorkoutVO> findAll(Pageable pageable) {
        return repo
                .findAll(pageable)
                .getContent()
                .parallelStream()
                .map(WorkoutVO::new)
                .collect(toUnmodifiableList());
    }
}
