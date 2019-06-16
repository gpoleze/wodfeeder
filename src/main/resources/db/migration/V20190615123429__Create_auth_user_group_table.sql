CREATE TABLE auth_group
(
    "id"   SERIAL       NOT NULL PRIMARY KEY,
    "name" VARCHAR(128) NOT NULL UNIQUE
);

INSERT INTO auth_group (name)
VALUES ('USER');
INSERT INTO auth_group (name)
VALUES ('ADMIN');

CREATE TABLE auth_user_group
(
    "id"            SERIAL  NOT NULL UNIQUE,
    "user_id"       INTEGER NOT NULL,
    "auth_group_id" INTEGER NOT NULL,
    CONSTRAINT auth_user_group_user_id_fk FOREIGN KEY ("user_id") REFERENCES "user" ("id"),
    CONSTRAINT auth_user_group_auth_group_fk FOREIGN KEY ("auth_group_id") REFERENCES "auth_group" ("id"),
    PRIMARY KEY ("user_id", "auth_group_id")
);