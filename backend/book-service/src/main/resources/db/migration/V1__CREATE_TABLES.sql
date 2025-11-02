CREATE TABLE books (
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

CREATE TABLE authors (
     id             SERIAL PRIMARY KEY,
     name           VARCHAR(255),
     biography      VARCHAR(255),
     created_at     TIMESTAMP,
     deleted_at     TIMESTAMP
  );

  CREATE TABLE author_books
  (
    id              SERIAL PRIMARY KEY,
    author_id       INTEGER,
    book_id         INTEGER,
    created_at      TIMESTAMP,
    deleted_at      TIMESTAMP

  )
