create database uni;

use uni;

CREATE TABLE Students (
    id INTEGER primary key auto_increment,
    name VARCHAR(128) not null,
    age INTEGER
);

CREATE TABLE Teachers (
    id INTEGER primary key auto_increment,
    name VARCHAR(128) not null,
    age INTEGER
);

CREATE TABLE Competencies (
    id INTEGER primary key auto_increment,
    title VARCHAR(128) not null
);

CREATE TABLE Teachers2Competencies (
    id INTEGER primary key auto_increment,
    teacher_id INTEGER,
    competencies_id INTEGER
);

CREATE TABLE Courses (
    id INTEGER primary key auto_increment,
    teacher_id INTEGER,
    title VARCHAR(128) not null,
    headman_id INTEGER
);

CREATE TABLE Students2Courses (
    id INTEGER primary key auto_increment,
    student_id INTEGER,
    course_id INTEGER
);

INSERT INTO Teachers (name, age) VALUES
	("Петр", 39),
	("Максим", 35),
	("Антон", 37),
	("Всеволод", 38),
	("Егор", 41),
	("Светлана", 32);

INSERT INTO Students (name, age) VALUES
	("Анатолий", 29),
	("Олег", 25),
	("Семен", 27),
	("Олеся", 28),
	("Ольга", 31),
	("Иван", 22);

INSERT INTO Competencies (title) VALUES
	("Математика"),
	("Информатика"),
	("Программирование"),
	("Графика");

INSERT INTO Teachers2Competencies (teacher_id, competencies_id) VALUES
	(1, 1),
	(2, 1),
	(2, 3),
	(3, 2),
	(4, 1),
	(5, 3);

INSERT INTO Courses (teacher_id, title, headman_id) VALUES
	(1, "Алгебра логики", 2),
	(2, "Математическая статистика", 3),
	(4, "Высшая математика", 5),
	(5, "Javascript", 1),
	(5, "Базовый Python", 1);

INSERT INTO Students2Courses (student_id, course_id) VALUES
	(1, 1),
	(2, 1),
	(3, 2),
	(3, 3),
	(4, 5);

-- 1) Вывести имена студентов и курсы, которые они проходят
SELECT
    t1.name, t3.title
FROM
    Students t1
        INNER JOIN
    Students2Courses t2 ON t1.id = t2.student_id
        INNER JOIN
	Courses t3 ON t2.course_id = t3.id;

-- 2) Вывести имена всех преподавателей с их компетенциями
SELECT
    t1.name, t3.title
FROM
    Teachers t1
        INNER JOIN
    Teachers2Competencies t2 ON t1.id = t2.teacher_id
        INNER JOIN
	Competencies t3 ON t2.competencies_id = t3.id;

-- 3) Найти преподавателя, у которого нет компетенций
SELECT
    *
FROM
    Teachers
    WHERE
    id NOT IN (SELECT
            teacher_id
        FROM
            Teachers2Competencies);

-- 4) Найти имена студентов, которые не проходят ни один курс
SELECT
    name
FROM
    Students
    WHERE
    id NOT IN (SELECT
            student_id
        FROM
            Students2Courses);

-- 5) Найти курсы, которые не посещает ни один студент
SELECT
    *
FROM
    Courses
    WHERE
    id NOT IN (SELECT
            course_id
        FROM
            Students2Courses);

-- 6) Найти компетенции, которых нет ни у одного преподавателя
SELECT
    *
FROM
    Competencies
    WHERE
    id NOT IN (SELECT
            competencies_id
        FROM
            Teachers2Competencies);

-- 7) Вывести название курса и имя старосты
SELECT
    t1.title, t2.name
FROM
    Courses t1
        INNER JOIN
    Students t2 ON t1.headman_id = t2.id;

-- 8) Вывести имя студента и имена старост, которые есть на курсах, которые он проходит
SELECT
    t1.name AS studentName, t3.title AS course, t4.name AS headmanName
FROM
    Students t1
        INNER JOIN
    Students2Courses t2 ON t1.id = t2.student_id
        INNER JOIN
	Courses t3 ON t2.course_id = t3.id
		INNER JOIN
	Students t4 ON t3.headman_id = t4.id;









