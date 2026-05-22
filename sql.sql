CREATE DATABASE studyflow;
CREATE TABLE user (
                      id BIGINT PRIMARY KEY AUTO_INCREMENT,
                      username VARCHAR(50) NOT NULL UNIQUE,
                      password VARCHAR(100) NOT NULL,
                      create_time DATETIME DEFAULT CURRENT_TIMESTAMP
);