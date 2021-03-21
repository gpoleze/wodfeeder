CREATE TABLE "exercise"
(
    "id"   UUID         NOT NULL UNIQUE,
    "name" VARCHAR(128) NOT NULL UNIQUE,
    PRIMARY KEY ("id")
);

CREATE TABLE "weight_type"
(
    "type" VARCHAR(32) NULL UNIQUE,
    PRIMARY KEY ("type")
);

CREATE TABLE "exercise_set"
(
    "id"          UUID     NOT NULL UNIQUE,
    "exercise_id" UUID     NOT NULL,
    "date"        DATE     NOT NULL,
    "reps"        SMALLINT NOT NULL,
    "weight"      REAL,
    "weight_type" VARCHAR(32),
    "observation" TEXT,
    PRIMARY KEY ("id"),
    CONSTRAINT exercise_set_exercise_id_fk FOREIGN KEY ("exercise_id") REFERENCES exercise ("id"),
    CONSTRAINT exercise_set_weight_type_fk FOREIGN KEY ("weight_type") REFERENCES weight_type ("type")

);

INSERT INTO weight_type(type)
VALUES ('kilo'),
       ('pounds'),
       ('resistance bands')
;