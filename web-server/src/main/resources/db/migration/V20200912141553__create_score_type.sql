CREATE TABLE "workout_scoring"
(
    "id" UUID PRIMARY KEY,
    "scoring" VARCHAR NOT NULL
);

ALTER TABLE "workout"
    ADD COLUMN "scoring" UUID NOT NULL,
    ADD CONSTRAINT "workout_scoring_fkey" FOREIGN KEY ("scoring") REFERENCES "workout_scoring"("id");

INSERT INTO "workout_scoring" (id, scoring)
VALUES (uuid_generate_v4(), 'Weight'),
       (uuid_generate_v4(), 'RFT'),
       (uuid_generate_v4(), 'AMRAP'),
       (uuid_generate_v4(), 'Rounds + Reps');