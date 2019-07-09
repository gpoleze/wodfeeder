CREATE TABLE auth_group
(
    "id"   BIGSERIAL    NOT NULL PRIMARY KEY,
    "name" VARCHAR(128) NOT NULL UNIQUE
);

CREATE TABLE auth_user_group
(
    "id"            BIGSERIAL NOT NULL UNIQUE,
    "user_id"       BIGINT    NOT NULL,
    "auth_group_id" BIGINT    NOT NULL,
    CONSTRAINT auth_user_group_user_id_fk FOREIGN KEY ("user_id") REFERENCES "user" ("id"),
    CONSTRAINT auth_user_group_auth_group_fk FOREIGN KEY ("auth_group_id") REFERENCES "auth_group" ("id"),
    PRIMARY KEY ("user_id", "auth_group_id")
);