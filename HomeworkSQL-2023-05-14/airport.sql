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
	id,
    service_class,
    price
FROM tickets
	WHERE CASE service_class
		WHEN 'Bussiness' THEN price > 100000
        WHEN 'PremiumEconomy' THEN price BETWEEN 20000 AND 30000
        WHEN 'Economy' THEN price BETWEEN 10000 AND 11000
	END;
    
    
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
         WHEN service_class = 'Economy' THEN price * 0.85
         WHEN service_class = 'Business' THEN price * 0.9
         WHEN service_class = 'PremiumEconomy' THEN price * 0.8
     END AS new_price
 FROM
     tickets;

