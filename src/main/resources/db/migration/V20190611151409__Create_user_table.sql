CREATE TABLE "user"
(
    "id"                  serial       NOT NULL PRIMARY KEY,
    "first_name"          VARCHAR(128) NOT NULL,
    "last_name"           VARCHAR(128),
    "username"            VARCHAR(128) NOT NULL UNIQUE,
    "password"            VARCHAR(128) NOT NULL,
    "expired"             boolean DEFAULT FALSE,
    "locked"              boolean DEFAULT FALSE,
    "credentials_expired" boolean DEFAULT FALSE,
    "enabled"             boolean DEFAULT TRUE
);
