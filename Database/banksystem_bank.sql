CREATE DATABASE bank_new;
USE bank_new;
CREATE TABLE bank (
    pin VARCHAR(30),
    date VARCHAR(50),
    type VARCHAR(20),
    amount VARCHAR(20)
);
CREATE TABLE login (
    card_number VARCHAR(30),
    pin_number VARCHAR(10)
);

INSERT INTO login VALUES ('12345678','1234');

CREATE TABLE signup (
    formno VARCHAR(20),
    name VARCHAR(40),
    fname VARCHAR(40),
    dob VARCHAR(20),
    gender VARCHAR(20),
    email VARCHAR(50),
    marital VARCHAR(20),
    address VARCHAR(80),
    city VARCHAR(30),
    pincode VARCHAR(10),
    state VARCHAR(30)
);
CREATE TABLE signup2 (
    formno VARCHAR(20),
    religion VARCHAR(30),
    category VARCHAR(30),
    income VARCHAR(30),
    education VARCHAR(40),
    occupation VARCHAR(40),
    pan VARCHAR(20),
    aadhar VARCHAR(20),
    seniorcitizen VARCHAR(10),
    existingaccount VARCHAR(10)
);

CREATE TABLE signup3 (
    formno VARCHAR(20),
    accounttype VARCHAR(40),
    cardno VARCHAR(20),
    pin VARCHAR(10),
    services VARCHAR(100)
);

SELECT * FROM bank_new.signup2 LIMIT 1000;

SELECT * FROM bank;