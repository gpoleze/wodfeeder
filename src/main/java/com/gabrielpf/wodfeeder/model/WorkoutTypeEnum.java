package com.gabrielpf.wodfeeder.model;

public enum WorkoutTypeEnum {
    WARM_UP("warm_up"),
    REST("rest"),
    DEVELOPMENT("development"),
    WOD("wod"),
    COOLDOWN("cooldown");

    private final String type;

    WorkoutTypeEnum(String type) {this.type = type;}

    public WorkoutType getType() {
        return new WorkoutType(type);
    }
}
