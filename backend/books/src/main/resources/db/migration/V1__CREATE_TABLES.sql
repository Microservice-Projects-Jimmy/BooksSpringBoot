CREATE TABLE books
  (
     id             SERIAL PRIMARY KEY,
     name           VARCHAR(255),
     author         VARCHAR(255),
     description    VARCHAR(225),
     image          VARCHAR(225),
     published_date TIMESTAMP,
     copy_count     INTEGER,
     created_at     TIMESTAMP,
     deleted_at     TIMESTAMP

  );

CREATE TABLE users
  (
     id             SERIAL PRIMARY KEY,
     name           VARCHAR(255),
     username       VARCHAR(255),
     password       VARCHAR(255),
     token          VARCHAR(255),
     created_at     TIMESTAMP,
     deleted_at     TIMESTAMP
  );

  CREATE TABLE users_books
  (
    id              SERIAL PRIMARY KEY,
    user_id         INTEGER,
    book_id         INTEGER,
    created_at      TIMESTAMP,
    deleted_at      TIMESTAMP

  )
