CREATE TABLE "workout_type"
(
    "type" VARCHAR PRIMARY KEY
);

CREATE TABLE "workout"
(
    "id"           SERIAL PRIMARY KEY NOT NULL,
    "date"         date               NOT NULL,
    "type"         varchar            NOT NULL,
    "position"     int                NOT NULL,
    "exercise"     text               NOT NULL,
    "part"         varchar(1),
    "name"         varchar(50),
    "reps"         varchar(50),
    "load"         varchar(10),
    "distance"     int,
    "duration"     int,
    "observations" text,
    CONSTRAINT "workout_type_fk" FOREIGN KEY ("type") REFERENCES workout_type (type)
);

INSERT INTO "workout_type"
    (type)
VALUES ('warm_up'),
       ('rest'),
       ('development'),
       ('wod'),
       ('cooldown')
;
