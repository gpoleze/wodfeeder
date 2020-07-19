package com.gabrielpf.wodfeeder.model;

import java.util.UUID;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.Type;


@MappedSuperclass
public class EntityWithUuid {
    @Id
    @Type(type = "pg-uuid")
    private UUID id;

    public EntityWithUuid() {
        this.id = UUID.randomUUID();
    }

    public UUID getId() {
        return id;
    }

    public Workout setId(UUID id) {
        this.id = id;
        return null;
    }
}
