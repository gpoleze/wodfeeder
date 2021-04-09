package com.gabrielpf.wodfeeder.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.gabrielpf.wodfeeder.model.WeightType;

public class WeightTypeForm {
    @NotNull
    @NotEmpty
    private String type;

    protected WeightTypeForm() {}

    public WeightTypeForm(@NotNull String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public WeightType convert() {
        return new WeightType(type);
    }
}
