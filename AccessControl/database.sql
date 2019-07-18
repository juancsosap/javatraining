CREATE DATABASE access;

USE access;

CREATE TABLE person (
	id INT NOT NULL AUTO_INCREMENT UNIQUE,
    name VARCHAR(150) NOT NULL,
    role VARCHAR(150) NOT NULL);
	
CREATE TABLE card (
    id INT NOT NULL UNIQUE,
    id_person INT NOT NULL UNIQUE,
    active BOOLEAN NOT NULL DEFAULT 0);
	
CREATE TABLE permision (
    id_card INT NOT NULL,
    id_zone INT NOT NULL);

CREATE TABLE zone (
    id INT NOT NULL AUTO_INCREMENT UNIQUE,
    name VARCHAR(100) NOT NULL);

create table track (
    id_card INT NOT NULL,
    id_zone INT NOT NULL,
    ingress DATETIME NOT NULL,
	egress DATETIME);
