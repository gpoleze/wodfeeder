package com.gabrielpf.wodfeeder.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.gabrielpf.wodfeeder.controller.form.ExerciseForm;

@Entity
@Table(name = "exercise")
public class Exercise extends EntityWithUuid {

    @Column(nullable = false, unique = true)
    private String name;

    protected Exercise() {}

    public Exercise(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
