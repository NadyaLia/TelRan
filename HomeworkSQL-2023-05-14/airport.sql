use air;

SELECT 
    id, price,
    CASE
        WHEN price BETWEEN 10000 AND 11000 THEN 'Economy'
        WHEN price BETWEEN 20000 AND 30000 THEN 'PremiumEconomy'
        WHEN price > 100000 THEN 'Business'
        ELSE service_class
    END AS service_class
FROM
    tickets;
    
SELECT 
    side_number,
    CASE
        WHEN production_year < 2000 THEN 'Old'
        WHEN production_year BETWEEN 2000 AND 2010 THEN 'Mid'
        ELSE 'New'
    END AS age
FROM
    airliners
    WHERE range_ < 10000
    ORDER BY age;
    
 SELECT 
     id,
     trip_id,
     CASE
         WHEN service_class = 'Economy' THEN price - (price * 0.15)
         WHEN service_class = 'Business' THEN price - (price * 0.1)
         WHEN service_class = 'PremiumEconomy' THEN price - (price * 0.2)
     END AS new_price
 FROM
     tickets;

