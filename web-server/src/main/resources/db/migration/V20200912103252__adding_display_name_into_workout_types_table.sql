ALTER TABLE workout_type ADD COLUMN id UUID DEFAULT uuid_generate_v4();

ALTER TABLE workout DROP CONSTRAINT workout_type_fkey;

UPDATE "workout" w
SET	type = wt.id
    FROM workout_type wt
WHERE w.type = wt.type;

ALTER TABLE workout_type
    DROP CONSTRAINT "workout_type_pkey";

ALTER TABLE workout_type
    ADD CONSTRAINT "workout_type_pkey" PRIMARY KEY (id);

ALTER TABLE "workout"
    ALTER COLUMN "type" TYPE UUID USING type::uuid,
    ADD CONSTRAINT "workout_type_fkey" FOREIGN KEY ("type") REFERENCES "workout_type" (id);

UPDATE "workout_type"
    SET "type" = 'Warm Up'
    WHERE "type" = 'warm_up';

UPDATE "workout_type"
    SET "type" = 'Rest'
    WHERE "type" = 'rest';

UPDATE "workout_type"
    SET "type" = 'Development'
    WHERE "type" = 'development';

UPDATE "workout_type"
    SET "type" = 'WOD'
    WHERE "type" = 'wod';

UPDATE "workout_type"
    SET "type" = 'Cooldown'
    WHERE "type" = 'cooldown';