package com.gabrielpf.wodfeeder.service;

import static java.util.stream.Collectors.toUnmodifiableList;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gabrielpf.wodfeeder.repo.WorkoutScoringRepo;
import com.gabrielpf.wodfeeder.vo.WorkoutScoringVO;

@Service
public class WorkoutScoringService {

    private final WorkoutScoringRepo scoringRepo;

    public WorkoutScoringService(WorkoutScoringRepo scoringRepo) {this.scoringRepo = scoringRepo;}

    public List<WorkoutScoringVO> findAll(){
        return scoringRepo
                .findAll()
                .stream()
                .map(WorkoutScoringVO::new)
                .collect(toUnmodifiableList());
    }
}
