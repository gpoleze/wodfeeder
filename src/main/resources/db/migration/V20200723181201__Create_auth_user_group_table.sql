CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE auth_group
(
    "id"   UUID         NOT NULL PRIMARY KEY,
    "name" VARCHAR(128) NOT NULL UNIQUE
);

CREATE TABLE auth_user_group
(
    "id"            UUID NOT NULL UNIQUE,
    "user_id"       UUID NOT NULL,
    "auth_group_id" UUID NOT NULL,
    CONSTRAINT auth_user_group_user_id_fk FOREIGN KEY ("user_id") REFERENCES "user" ("id"),
    CONSTRAINT auth_user_group_auth_group_fk FOREIGN KEY ("auth_group_id") REFERENCES "auth_group" ("id"),
    PRIMARY KEY ("user_id", "auth_group_id")
);

INSERT INTO auth_group (id, name)
VALUES (uuid_generate_v4(), 'admin'),
       (uuid_generate_v4(), 'common');