GRANT ALL PRIVILEGES ON DATABASE androidSb TO postgres;



CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    password varchar(255) NOT NULL,
    created_date TIMESTAMP,
    modified_date TIMESTAMP
);
