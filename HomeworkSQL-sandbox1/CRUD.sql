-- Вывести страны поставщиков
SELECT country
FROM [Suppliers]

-- Вывести имена и страны клиентов не из USA и China
SELECT CustomerName, Country
FROM [Customers]
WHERE Country NOT IN ('China', 'USA')

-- Вывести три самых дешевых товара в категории Beverages
SELECT * 
FROM [Products]
WHERE CategoryID = 1
ORDER BY Price ASC
LIMIT 3

-- Добавить нового поставщика из China (с произвольными данными)
INSERT INTO [Suppliers] 
VALUES (1, 'China sourcing', 'Camry Peng', '601 Yunling Lu', 'Shanghai', '200062', 'China', '(086) 02162106017')

-- Для всех товаров из категорий 1 и 3 увеличить стоимость на 25.5%
UPDATE 'Products' 
SET 'Price' = 'Price' + ('Price' * 0.255) 
WHERE 'CategoryID' IN (1, 3)

-- Удалить всех поставщиков не из Spain и не из Japan
DELETE FROM Suppliers
WHERE Country NOT IN ('Spain', 'Japan') 