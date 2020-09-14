package com.gabrielpf.wodfeeder.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "workout_scoring")
public class WorkoutScoring extends EntityWithUuid {
    @Column
    private String scoring;

    protected WorkoutScoring() {}

    public WorkoutScoring(String scoring) {
        this.scoring = scoring;
    }

    public String getScoring() {
        return scoring;
    }

    public void setScoring(String scoring) {
        this.scoring = scoring;
    }
}
