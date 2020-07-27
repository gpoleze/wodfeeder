package com.gabrielpf.wodfeeder.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.gabrielpf.wodfeeder.controller.form.WorkoutForm;
import com.gabrielpf.wodfeeder.service.WorkoutService;
import com.gabrielpf.wodfeeder.vo.WorkoutVO;

@RestController
@RequestMapping(value = "/api/workouts", produces = "application/json")
public class WorkoutsController {

    private final WorkoutService workoutService;

    @Autowired
    public WorkoutsController(WorkoutService workoutService) {
        this.workoutService = workoutService;
    }

    @GetMapping
    public List<WorkoutVO> workouts(@PageableDefault(size = 50) Pageable pageable) {
        return workoutService.findAll(pageable);
    }

    @GetMapping(params = "date")
    public List<WorkoutVO> workouts(@RequestParam LocalDate date) {
        return workoutService.findByDate(date);
    }

    @GetMapping("/{id}")
    public WorkoutVO workouts(@PathVariable UUID id) {
        return workoutService.findById(id);
    }

    @PostMapping
    public ResponseEntity<WorkoutVO> save(@Valid @RequestBody WorkoutForm form, UriComponentsBuilder uriBuilder) {
        final WorkoutVO vo = workoutService.save(form);
        final var uri = uriBuilder.path("/api/workouts/{id}").buildAndExpand(vo.getId()).toUri();
        return ResponseEntity.created(uri).body(vo);
    }
}
