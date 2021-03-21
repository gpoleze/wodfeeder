package com.gabrielpf.wodfeeder.service;

import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.gabrielpf.wodfeeder.controller.form.ExerciseForm;
import com.gabrielpf.wodfeeder.model.Exercise;
import com.gabrielpf.wodfeeder.vo.ExerciseVO;
import com.gabrielpf.wodfeeder.repo.ExerciseRepo;

@Service
public class ExercisesService {

    private final ExerciseRepo exerciseRepo;

    public ExercisesService(ExerciseRepo exerciseRepo) {
        this.exerciseRepo = exerciseRepo;
    }

    public List<ExerciseVO> findAll(){
        return exerciseRepo
                .findAll()
                .stream()
                .map(ExerciseVO::new)
                .collect(toList());
    }

    public ExerciseVO save(ExerciseForm form) {
        var exercise = form.convert();
        exerciseRepo.save(exercise);
        return new ExerciseVO(exercise);
    }

    public Optional<Exercise> find(UUID id) {
        return exerciseRepo.findById(id);
    }

    public List<ExerciseVO> find(String name) {
        return exerciseRepo
                .findByNameContainingIgnoringCase(name)
                .stream()
                .map(ExerciseVO::new)
                .collect(Collectors.toUnmodifiableList());
    }
}
