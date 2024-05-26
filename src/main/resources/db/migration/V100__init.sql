DROP TABLE IF EXISTS request_log CASCADE;

CREATE TABLE request_log (
   id UUID PRIMARY KEY,
   path VARCHAR(255) NOT NULL,
   created TIMESTAMP,
   modified TIMESTAMP
);