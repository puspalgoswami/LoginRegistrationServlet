CREATE DATABASE login_db;
USE login_db;

CREATE TABLE students (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    enrollment VARCHAR(50),
    batch VARCHAR(30),
    email VARCHAR(100),
    mobile VARCHAR(20),
    dob DATE,
    address VARCHAR(255),
    state VARCHAR(50),
    city VARCHAR(50),
    username VARCHAR(50) UNIQUE,
    password VARCHAR(100)
);
