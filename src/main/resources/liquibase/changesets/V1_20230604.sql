CREATE TABLE IF NOT EXISTS _user (
                       id SERIAL PRIMARY KEY,
                       firstname VARCHAR(255) ,
                       lastname VARCHAR(255) ,
                       email VARCHAR(255) UNIQUE ,
                       password VARCHAR(255) ,
                       role VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS token (
                       id SERIAL PRIMARY KEY,
                       token VARCHAR(255) ,
                       tokenType VARCHAR(255) ,
                       revoked BOOLEAN DEFAULT false,
                       expired BOOLEAN DEFAULT false,
                       user_id INT NOT NULL REFERENCES _user(id)
);
