package com.gabrielpf.wodfeeder.dao;

import org.springframework.stereotype.Service;

import com.gabrielpf.wodfeeder.repo.WorkoutRepo;

@Service
public class WorkoutDao {

    private final WorkoutRepo repo;

    public WorkoutDao(WorkoutRepo repo) {this.repo = repo;}
}
