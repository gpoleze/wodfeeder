package com.gabrielpf.wodfeeder.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.gabrielpf.wodfeeder.controller.form.WeightTypeForm;
import com.gabrielpf.wodfeeder.vo.WeightTypeVO;

@Entity
@Table(name = "weight_type")
public class WeightType extends EntityWithUuid {
    @Column(unique = true)
    private String type;

    protected WeightType() {}

    public WeightType(String type) {
        this.type = type;
    }

    public WeightType(WeightTypeVO weightTypeVO) {
        this.type = weightTypeVO.getType();
    }

    public String getType() { return type; }

    public void setType(String type) { this.type = type; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WeightType that = (WeightType) o;
        return Objects.equals(type, that.type);
    }

    @Override
    public int hashCode() { return Objects.hash(type); }
}
