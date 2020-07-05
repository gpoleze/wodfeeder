package com.gabrielpf.wodfeeder.vo;


import java.time.LocalDate;

public class WorkoutVO {
    //    date	Type	Position	Part	Name	Exercise	Reps	Load	Distance(m)	Time(min)	Time(s)	Observations
    private final LocalDate date;
    private final String type;

    public WorkoutVO() {
        date = LocalDate.now();
        type = "WOD";
    }

    public LocalDate getDate() { return date; }

    public String getType() { return type; }
}
