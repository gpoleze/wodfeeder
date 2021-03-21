package com.gabrielpf.wodfeeder.controller.form;

import javax.validation.constraints.NotEmpty;

import com.gabrielpf.wodfeeder.model.Exercise;

public class ExerciseForm {
    @NotEmpty
    private String name;

    protected ExerciseForm() {}

    public ExerciseForm(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Exercise convert() {
        return new Exercise(name);
    }
}
