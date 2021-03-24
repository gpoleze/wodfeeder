package com.gabrielpf.wodfeeder.controller;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gabrielpf.wodfeeder.controller.form.ExerciseForm;
import com.gabrielpf.wodfeeder.model.Exercise;
import com.gabrielpf.wodfeeder.service.ExercisesService;
import com.gabrielpf.wodfeeder.vo.ExerciseVO;

@RestController
@RequestMapping(path = "/api/exercises", produces = MediaType.APPLICATION_JSON_VALUE)
public class ExerciseController {

    private final ExercisesService exercisesService;

    public ExerciseController(ExercisesService exercisesService) {
        this.exercisesService = exercisesService;
    }

    @GetMapping
    public List<ExerciseVO> list(@RequestParam(required = false) String name) {
        if (name == null)
            return exercisesService.findAll();
        return exercisesService.find(name);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExerciseVO> findById(@PathVariable UUID id) {
        return ResponseEntity.of(exercisesService.find(id));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasAuthority('admin')")
    public ExerciseVO create(@Valid @RequestBody ExerciseForm form) {
        return exercisesService.save(form);
    }
}
