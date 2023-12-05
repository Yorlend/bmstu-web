-- create read-only user
CREATE USER reader WITH PASSWORD 'password';
GRANT USAGE ON SCHEMA public TO reader;
GRANT SELECT ON ALL TABLES IN SCHEMA public TO reader;
