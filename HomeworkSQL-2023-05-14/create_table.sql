CREATE TABLE goods (
  id INTEGER PRIMARY KEY,
  title VARCHAR(128),
  quantity INTEGER
);
 
INSERT INTO goods (id, title, quantity) values
	(1, 'bike', 4),
    (2, 'ski', 5),
    (3, 'roller', 7),
    (4, 'skate', 2);
    
ALTER TABLE goods
ADD COLUMN price integer default 0;

SELECT *
FROM goods;

ALTER TABLE goods
DROP COLUMN id;

ALTER TABLE goods
RENAME COLUMN title TO product_name;

ALTER TABLE goods
ADD COLUMN discount DECIMAL;

DROP TABLE goods;

CREATE TABLE tasks (
  task_id INTEGER AUTO_INCREMENT PRIMARY KEY,
  title VARCHAR(128) NOT NULL,
  responsible_person VARCHAR(128)
);
 
INSERT INTO tasks (title, responsible_person) values
	('Report', 'Smith'),
    ('Calculation', 'Bobrov'),
    ('Research', 'Petrova');