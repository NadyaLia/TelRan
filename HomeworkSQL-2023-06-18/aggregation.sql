-- Найти все заказы, содержащие продукт с id 1
SELECT *
FROM OrderDetails
JOIN Orders ON OrderDetails.OrderID = Orders.OrderID
AND ProductID = 1;

-- Вывести ко-во заказов, закрепленных за каждым менеджером
SELECT
        Employees.EmployeeID,
        Employees.LastName,
        Employees.FirstName,
    	COUNT(*) AS Orders_amount
FROM Orders
JOIN Employees ON Employees.EmployeeID = Orders.EmployeeID
GROUP BY Employees.EmployeeID
ORDER BY Employees.EmployeeID;

-- Вывести стоимость и название двух самых дешевых товаров из Germany
SELECT
	Products.ProductName,
    Products.Price,
    Suppliers.Country
FROM Products
JOIN Suppliers ON Suppliers.SupplierID = Products.SupplierID
WHERE Country = 'Germany'
ORDER BY Price
LIMIT 2;

-- Вывести ко-во заказов, которое компания Speedy Express доставила в Brazil
SELECT
	Shippers.ShipperName,
    COUNT(*) AS Orders_cnt
FROM Orders
JOIN Shippers ON Shippers.ShipperID = Orders.ShipperID
JOIN Customers ON Customers.CustomerID = Orders.CustomerID
WHERE Shippers.ShipperName = 'Speedy Express' AND Customers.Country = 'Brazil';

-- Вывести среднюю стоимость напитка из USA
SELECT
	AVG(Price)
FROM Products
JOIN Categories ON Products.CategoryID = Categories.CategoryID
JOIN Suppliers ON Suppliers.SupplierID = Products.SupplierID
WHERE Categories.CategoryName = 'Beverages' AND Suppliers.Country = 'USA';
