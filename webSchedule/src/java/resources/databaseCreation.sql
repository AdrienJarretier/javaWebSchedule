/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Laurie
 * Created: 30 nov. 2016
 */

-- DROP TABLE lesson_participants;
-- DROP TABLE lesson;
-- DROP TABLE staff;
-- DROP TABLE degree;
-- DROP TABLE class_room;

CREATE TABLE class_room (
	id INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
	building VARCHAR(30),
	room_nb INT,
	capacity INT
);

CREATE TABLE degree(
	id INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
	name VARCHAR(30) UNIQUE,
	student_counts INT
);


CREATE TABLE staff (
	id INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY
        (START WITH 1, INCREMENT BY 1), 
	email VARCHAR(30) UNIQUE, 
	first_name VARCHAR(30),
	last_name VARCHAR(30), 
	password CHAR(32) FOR BIT DATA,
	is_admin BOOLEAN
);


CREATE TABLE lesson (
	id INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY
        (START WITH 1, INCREMENT BY 1),
	time_start TIMESTAMP,
	time_end TIMESTAMP, 
	title VARCHAR(30), 
	class_room_id INT REFERENCES class_room,
	teacher_id INT REFERENCES staff 
);


CREATE TABLE lesson_participants(
	degree_id INT REFERENCES degree,
	lesson_id INT REFERENCES lesson
);
