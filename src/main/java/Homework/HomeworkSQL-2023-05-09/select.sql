use hr;

SELECT 
    first_name, last_name, salary
FROM
    employees
WHERE
    first_name = 'Lex'
        AND last_name = 'De Haan';

SELECT 
    *
FROM
    employees
WHERE
    job_id = 'FIACCOUNT' AND salary < 8000;

SELECT 
    *
FROM
    employees
WHERE
    last_name LIKE '%kk%' OR '%ll%';

SELECT 
    *
FROM
    employees
WHERE
    commission_pct IS NULL;

SELECT 
    *
FROM
    employees
WHERE
    department_id != 80
        OR department_id != 110;

SELECT 
    *
FROM
    employees
WHERE
    salary BETWEEN 5000 AND 7000;
    
