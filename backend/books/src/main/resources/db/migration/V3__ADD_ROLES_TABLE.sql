CREATE TABLE roles (
    id      SERIAL PRIMARY KEY,
    name    VARCHAR(255)
);
ALTER TABLE users ADD COLUMN role_id INTEGER CONSTRAINT fk_role_id REFERENCES roles(id);