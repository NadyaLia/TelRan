drop database shop;
create database shop;
use shop;
CREATE TABLE customers (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(20),
    lastname VARCHAR(20),
    gender char(1) check(gender in ('f', 'm')),
    age integer
);

CREATE TABLE orders (
    id INT PRIMARY KEY AUTO_INCREMENT,
    customerid integer,
    productid integer,
    ordertype varchar(128),
    productcount integer
);

CREATE TABLE products (
    id INT PRIMARY KEY AUTO_INCREMENT,
    title varchar(128),
    price numeric(8, 2)
);


INSERT INTO orders (customerid, productid, ordertype, productcount) VALUES (1, 3, 'online', 3);
INSERT INTO orders (customerid, productid, ordertype, productcount) VALUES (1, 2, 'online', 5);
INSERT INTO orders (customerid, productid, ordertype, productcount) VALUES (3, 1, 'direct', 2);
INSERT INTO orders (customerid, productid, ordertype, productcount) VALUES (3, 4, 'direct', 6);
INSERT INTO orders (customerid, productid, ordertype, productcount) VALUES (3, 3, 'direct', 3);
INSERT INTO orders (customerid, productid, ordertype, productcount) VALUES (1, 3, 'online', 4);
INSERT INTO orders (customerid, productid, ordertype, productcount) VALUES (5, 7, 'online', 2);
INSERT INTO orders (customerid, productid, ordertype, productcount) VALUES (5, 9, 'online', 7);
INSERT INTO orders (customerid, productid, ordertype, productcount) VALUES (6, 5, 'direct', 4);


INSERT INTO customers (name, lastname, age, gender) VALUES ('Гайк', 'Инанц', 29, 'm');
INSERT INTO customers (name, lastname, age, gender) VALUES ('Максим', 'Грибов', 32, 'm');
INSERT INTO customers (name, lastname, age, gender) VALUES ('Антон', 'Куликов', 27, 'm');
INSERT INTO customers (name, lastname, age, gender) VALUES ('Юрий', 'Митрофанов', 30, 'm');
INSERT INTO customers (name, lastname, age, gender) VALUES ('Нелли', 'Ефремян', 25, 'f');
INSERT INTO customers (name, lastname, age, gender) VALUES ('Ольга', 'Степанова', 35, 'f');


INSERT INTO products (title, price) VALUES ('молоко', 70);
INSERT INTO products (title, price) VALUES ('колбаса', 230);
INSERT INTO products (title, price) VALUES ('хлопья', 150);
INSERT INTO products (title, price) VALUES ('хлеб', 30);
INSERT INTO products (title, price) VALUES ('масло', 120);
INSERT INTO products (title, price) VALUES ('чипсики', 60);
INSERT INTO products (title, price) VALUES ('шоколад', 70);
INSERT INTO products (title, price) VALUES ('кетчуп', 150);
INSERT INTO products (title, price) VALUES ('яблоко', 70);

-- 1) вывести название продукта, который чаще всего встречается в заказах
SELECT
    t2.title, COUNT(*) AS frequency
FROM
    orders t1
        JOIN
    products t2 ON t1.productid = t2.id
GROUP BY t2.title
ORDER BY frequency DESC
LIMIT 1;

-- 2) вывести название продукта, который покупают чаще всего (нужно посчитать общее количество купленных единиц)
SELECT
    products.title, agg.total_quantity
FROM
    (SELECT
        productid, SUM(productcount) AS total_quantity
    FROM
        orders
    GROUP BY productid) agg
        JOIN
    products ON agg.productid = products.id
ORDER BY agg.total_quantity DESC
LIMIT 1;


-- 3) вывести общую выручку магазина. Сумма всех купленных единиц товара.
SELECT
    SUM(t1.productcount * t2.price) AS total_income
FROM
    orders t1
        JOIN
    products t2 ON t1.productid = t2.id;

-- 4) определить сумму выручки за онлайн продажи (online) и за продажи в магазине (direct)
SELECT
	t1.ordertype,
    SUM(t1.productcount * t2.price) AS revenue
FROM
    orders t1
        JOIN
    products t2 ON t1.productid = t2.id
    GROUP BY t1.ordertype;



