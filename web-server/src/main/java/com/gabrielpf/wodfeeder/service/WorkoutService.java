package com.gabrielpf.wodfeeder.service;

import static java.util.stream.Collectors.toUnmodifiableList;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Pageable;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.gabrielpf.wodfeeder.controller.form.WorkoutForm;
import com.gabrielpf.wodfeeder.model.Workout;
import com.gabrielpf.wodfeeder.repo.WorkoutRepo;
import com.gabrielpf.wodfeeder.repo.WorkoutScoringRepo;
import com.gabrielpf.wodfeeder.repo.WorkoutTypeRepo;
import com.gabrielpf.wodfeeder.vo.WorkoutVO;

@Service
public class WorkoutService {

    private final WorkoutRepo workoutRepo;
    private final WorkoutTypeRepo workoutTypeRepo;
    private final WorkoutScoringRepo workoutScoringRepo;

    public WorkoutService(WorkoutRepo workoutRepo, WorkoutTypeRepo workoutTypeRepo, WorkoutScoringRepo workoutScoringRepo) {
        this.workoutRepo = workoutRepo;
        this.workoutTypeRepo = workoutTypeRepo;
        this.workoutScoringRepo = workoutScoringRepo;
    }

    public List<WorkoutVO> findByDate(LocalDate date) {
        return workoutRepo.findByDate(date)
                .orElse(Collections.emptyList())
                .stream()
                .map(WorkoutVO::new)
                .collect(toUnmodifiableList());
    }

    public List<WorkoutVO> findAll(Pageable pageable) {
        return workoutRepo
                .findAll(pageable)
                .getContent()
                .parallelStream()
                .map(WorkoutVO::new)
                .collect(toUnmodifiableList());
    }

    public WorkoutVO findById(UUID id) {
        return workoutRepo
                .findById(id)
                .map(WorkoutVO::new)
                .orElseThrow(ResourceNotFoundException::new);
    }

    public WorkoutVO save(WorkoutForm form) {
        final var workoutType = workoutTypeRepo
                .findByType(form.getType())
                .orElseThrow(() -> new RuntimeException("Workout Type not present in the Database"));

        final var workoutScoring = workoutScoringRepo
                .findByScoring(form.getScoring())
                .orElseThrow(() -> new RuntimeException("Workout Scoring not present in the Database"));

        Workout workout = form.convert(workoutType, workoutScoring);
        workoutRepo.save(workout);
        return new WorkoutVO(workout);
    }
}
