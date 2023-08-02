use hr;
    
SELECT 
    department_id,
    MAX(CASE 			-- returns the largest value of the selected column; https://www.w3schools.com/sql/sql_min_max.asp
        WHEN salary > 10000 THEN 1
        ELSE 0
    END) AS above10k
FROM
    employees
GROUP BY department_id;

SELECT 
    department_id,
    MIN(CASE			-- returns the smallest value of the selected column
        WHEN salary < 10000 THEN 0
        ELSE 1
    END) AS above10k
FROM
    employees
GROUP BY department_id;

SELECT 
    *
FROM
    employees
ORDER BY last_name;

SELECT 
    *
FROM
    employees
ORDER BY salary DESC;

SELECT 
    *
FROM
    employees
WHERE department_id IN (60, 90, 110)	--  allows you to specify multiple values in a WHERE clause; is a shorthand for multiple OR conditions
ORDER BY last_name;

SELECT 
    *
FROM
    employees
WHERE job_id = 'ST_CLERK'
ORDER BY salary DESC;

SELECT 
    *
FROM
    employees
WHERE first_name LIKE 'D%'
ORDER BY last_name;
