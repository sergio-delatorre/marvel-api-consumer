DROP TABLE IF EXISTS service_request_log CASCADE;

CREATE TABLE service_request_log (
   id UUID PRIMARY KEY,
   path VARCHAR(255) NOT NULL,
   created TIMESTAMP,
   modified TIMESTAMP
);