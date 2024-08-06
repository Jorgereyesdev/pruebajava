Querys de la base de datos
use RiwiAcademyDb;

CREATE TABLE courses (
id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
name varchar(250) NOT NULL);

CREATE TABLE grades (
id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
grade float NOT NULL,
description ENUM('QUIZ', 'EXAM', 'WORKSHOP'),
id_course int,
FOREIGN KEY (id_course) REFERENCES courses(id)
);

CREATE TABLE students (
id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
name varchar(30) NOT NULL,
lastname varchar(30) NOT NULL,
email varchar(50) NOT NULL UNIQUE,
state Boolean DEFAULT TRUE,
id_course int,
id_grade int,
FOREIGN KEY (id_course) REFERENCES courses(id),
FOREIGN KEY (id_grade) REFERENCES grades(id) ON DELETE CASCADE
);

CREATE TABLE registrations (
id int NOT NULL PRIMARY KEY,
id_course int,
id_student int,
FOREIGN KEY (id_course) REFERENCES courses(id) ON DELETE CASCADE,
FOREIGN KEY (id_student) REFERENCES students(id) ON DELETE CASCADE
);

