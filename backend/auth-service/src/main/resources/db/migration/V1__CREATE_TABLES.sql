
CREATE TABLE users (
     id             SERIAL PRIMARY KEY,
     first_name     VARCHAR(255),
     last_name      VARCHAR(255),
     username       VARCHAR(255),
     password       VARCHAR(255),
     email          VARCHAR(255),
     token          VARCHAR(255),
     authorities    VARCHAR(255)[],
     created_at     TIMESTAMP,
     deleted_at     TIMESTAMP,
     updated_at     TIMESTAMP,
     is_deleted     BOOLEAN NOT NULL DEFAULT FALSE
  );


