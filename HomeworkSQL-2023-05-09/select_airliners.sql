use air;

SELECT 
    model_name,
    CASE
        WHEN range_ BETWEEN 1000 AND 2500 THEN 'short-haul'
        WHEN range_ BETWEEN 2501 AND 6000 THEN 'medium-haul'
        ELSE 'long-haul'
    END AS category
FROM
    airliners;
    
SELECT 
    model_name,
    CASE
        WHEN range_ BETWEEN 1000 AND 2500 THEN 'short-haul'
        WHEN range_ BETWEEN 2501 AND 6000 THEN 'medium-haul'
        WHEN range_ > 6001 THEN 'long-haul'
        -- added airline with range < 1000 to airport.txt
        ELSE 'UNDEFINED'
    END AS category
FROM
    airliners;