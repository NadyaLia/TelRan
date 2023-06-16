USE hr;

-- Найти количество сотрудников в каждом департаменте. Вывести departmentid и employeescnt
SELECT
    department_id, COUNT(*) AS employee_cnt
FROM
    employees
GROUP BY department_id;

-- Найти количество сотрудников в каждом департаменте. Вывести departmentname и employeescnt
SELECT
    t1.department_name, t2.employees_cnt
FROM
    departments t1
        JOIN
    (SELECT
        department_id, COUNT(*) AS employees_cnt
    FROM
        employees
    WHERE
        department_id IS NOT NULL
    GROUP BY department_id) t2 ON t1.department_id = t2.department_id;

-- Найти количество сотрудников у каждого менеджера. Вывести managerid и employeescnt
SELECT
    manager_id, COUNT(*) AS employees_cnt
FROM
    employees
GROUP BY manager_id;

-- Найти количество сотрудников у каждого менеджера. Вывести firstname,  lastname и employees_cnt
SELECT
    t1.first_name, t1.last_name, t2.employees_cnt
FROM
    employees t1
        JOIN
    (SELECT
        manager_id, COUNT(*) AS employees_cnt
    FROM
        employees
    WHERE
        manager_id IS NOT NULL
    GROUP BY manager_id) t2 ON t1.employee_id = t2.manager_id;

-- Найти максимальную зарплату в каждом департаменте. Вывести departmentid и maxsalary
SELECT
    department_id, MAX(salary) AS max_salary
FROM
    employees
GROUP BY department_id;

-- Найти сотрудников, у которых наибольшая зарплата в их департаменте
SELECT
    t1.first_name, t1.last_name, t1.department_id, t1.salary
FROM
    employees t1
        JOIN
    (SELECT
        department_id, MAX(salary) AS max_salary
    FROM
        employees
    GROUP BY department_id) t2 ON t1.department_id = t2.department_id AND t1.salary = t2.max_salary;
