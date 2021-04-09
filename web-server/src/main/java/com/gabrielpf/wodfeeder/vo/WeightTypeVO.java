package com.gabrielpf.wodfeeder.vo;

import java.util.UUID;

import com.gabrielpf.wodfeeder.model.WeightType;

public class WeightTypeVO {
    private final UUID id;
    private final String type;

    public WeightTypeVO(UUID id, String type) {
        this.id = id;
        this.type = type;
    }

    public WeightTypeVO(WeightType weightType) {
        this.id = weightType.getId();
        this.type = weightType.getType();
    }

    public UUID getId() {
        return id;
    }

    public String getType() {
        return type;
    }

}
