CREATE TABLE "user"
(
    "id"                  UUID PRIMARY KEY,
    "first_name"          VARCHAR(128) NOT NULL,
    "last_name"           VARCHAR(128) NOT NULL,
    "username"            VARCHAR(128) NOT NULL UNIQUE,
    "password"            VARCHAR(128) NOT NULL,
    "expired"             BOOLEAN DEFAULT FALSE,
    "locked"              BOOLEAN DEFAULT FALSE,
    "credentials_expired" BOOLEAN DEFAULT FALSE,
    "enabled"             BOOLEAN DEFAULT TRUE
);
