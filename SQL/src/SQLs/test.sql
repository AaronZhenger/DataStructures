-- Creates Table
CREATE TABLE IF NOT EXISTS student(id INTEGER PRIMARY KEY NOT NULL, first_name TEXT, last_name TEXT);

-- Adds Students
-- INSERT INTO student(id, first_name, last_name)
-- VALUES
-- (7,'josh','smith'),
-- (8,'tina','shoemaker');

describe student;

-- Shows Table
Select * from student;

SHOW TABLES

-- Deletes Students
-- DELETE FROM student where id>=0

-- Deletes Table
-- DROP TABLE student;