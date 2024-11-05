CREATE DATABASE property_search_db;

CREATE TABLE IF NOT EXISTS property_user (
	_id INT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(100),
    last_name VARCHAR(100),
    sex VARCHAR(100),
    income_bracket INT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
    
);

CREATE TABLE IF NOT EXISTS property_listing(
	id INT PRIMARY KEY AUTO_INCREMENT,
    property_name VARCHAR(100),
    location VARCHAR(100),
    property_type VARCHAR (100),
    price VARCHAR (100),
    is_available BOOLEAN DEFAULT TRUE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    _id INT NOT NULL,
    FOREIGN KEY (_id)
    REFERENCES property_user (_id)
);

CREATE TABLE IF NOT EXISTS property_security (
id INT PRIMARY KEY AUTO_INCREMENT,
first_name VARCHAR(100)  NOT NULL NOT NULL DEFAULT 'John',
last_name VARCHAR(100) NOT NULL NOT NULL DEFAULT 'Doe',
email VARCHAR(100)  UNIQUE NOT NULL,
user_password VARCHAR(100) NOT NULL,
property_role VARCHAR(100) NOT NULL DEFAULT 'Property User'
);

CREATE TABLE IF NOT EXISTS blog_post (
id INT PRIMARY KEY AUTO_INCREMENT,
title VARCHAR(100)  NOT NULL NOT NULL,
content VARCHAR(100) NOT NULL NOT NULL,
author VARCHAR(100)  UNIQUE NOT NULL,
published_date DATE NOT NULL
);

CREATE TABLE IF NOT EXISTS contact_form (
id INT PRIMARY KEY AUTO_INCREMENT,
first_name VARCHAR(100)  NOT NULL NOT NULL,
last_name VARCHAR(100) NOT NULL NOT NULL,
email VARCHAR(100)  UNIQUE NOT NULL,
message VARCHAR (100) UNIQUE NOT NULL,
submitted_date_and_time DATETIME NOT NULL
);

CREATE TABLE IF NOT EXISTS feature (
id INT PRIMARY KEY AUTO_INCREMENT,
title VARCHAR(100)  NOT NULL NOT NULL,
feature_description VARCHAR(100) NOT NULL NOT NULL,
img_url VARCHAR(100)  UNIQUE NOT NULL
);

INSERT INTO property_user (first_name, last_name, sex, income_bracket) VALUES 
('Ekene', 'Uzodinma', 'Male', 10000),
('Adekunle', 'Olabiyi', 'Male', 20000),
('Ekene', 'Uzodinma', 'Male', 10000),
('Tayo', 'Osunkiyesi', 'Male', 300000),
('Ekene', 'Uzodinma', 'Male', 10000);