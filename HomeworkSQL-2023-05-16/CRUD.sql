SET SQL_SAFE_UPDATES = 0;

drop table students;
CREATE TABLE students (
    name VARCHAR (128) not null,
    lastname VARCHAR(128) not null,
    avg_mark NUMERIC (16,1) CHECK (avg_mark BETWEEN 0 AND 10000),
    gender VARCHAR (128) check (gender in ('M', 'F'))
);

insert into students (name, lastname, avg_mark, gender) values ('Олег', 'Петров', 4.3, 'M'),
												('Семен', 'Степанов', 3.1, 'M'),
												('Ольга', 'Семенова', 4.7, 'F'),
												('Игорь', 'Романов', 3.1, 'M'),
                                                ('Ирина', 'Иванова', 2.2, 'F');
                                                
SELECT DISTINCT
    avg_mark
FROM
    students;
    
UPDATE students 
SET 
    avg_mark = avg_mark * 10;

UPDATE students 
SET 
    lastname = 'Сидоров'
WHERE
    lastname = 'Петров' AND name like 'Олег';

UPDATE students 
SET 
    avg_mark = avg_mark + 10
WHERE
    avg_mark < 31;


                                                