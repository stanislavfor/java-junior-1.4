CREATE DATABASE IF NOT EXISTS jpa_tutorial;

-- Используется база данных с названием jpa_tutorial
USE jpa_tutorial;

-- Создается таблица "persons"
CREATE TABLE IF NOT EXISTS persons (
   id BIGINT AUTO_INCREMENT PRIMARY KEY,
   first_name VARCHAR(255) NOT NULL,
   last_name VARCHAR(255) NOT NULL,
   age INT NOT NULL
);