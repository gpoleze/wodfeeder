CREATE TABLE "workout_type"
(
    "type" TEXT PRIMARY KEY
);

CREATE TABLE "workout"
(
    "id"       UUID PRIMARY KEY,
    "date"     DATE NOT NULL,
    "type"     TEXT NOT NULL,
    "position" INT  NOT NULL,
    "exercise" TEXT NOT NULL,
    "notes"    TEXT,
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
