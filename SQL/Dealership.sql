CREATE TABLE IF NOT EXISTS New_Dealerships (
    dealership_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50),
    address VARCHAR(50),
    phone VARCHAR(12)
);


INSERT INTO New_Dealerships (name, address, phone) VALUES
('Elite Motors', '123 Main Street', '123-456-7890'),
('Dynamic Autos', '456 Oak Avenue', '987-654-3210'),
('Express Cars', '789 Pine Lane', '555-123-4567');


CREATE TABLE IF NOT EXISTS Another_New_Vehicles (
    vin INT PRIMARY KEY,
    year INT,
    make VARCHAR(30),
    model VARCHAR(30),
    vehicleType VARCHAR(30),
    color VARCHAR(12),
    odometer INT,
    price FLOAT
);


INSERT INTO Another_New_Vehicles (vin, year, make, model, vehicleType, color, odometer, price) VALUES
(123456, 2022, 'Toyota', 'Camry', 'Sedan', 'Blue', 15000, 25000.00),
(789012, 2020, 'Honda', 'Civic', 'Sedan', 'Red', 18000, 22000.50);


CREATE TABLE IF NOT EXISTS New_Inventory (
    dealership_id INT,
    vin INT,
    FOREIGN KEY (dealership_id) REFERENCES New_Dealerships (dealership_id),
    FOREIGN KEY (vin) REFERENCES Another_New_Vehicles (vin)
);


INSERT INTO New_Inventory (dealership_id, vin) VALUES
(1, 123456),
(2, 789012);


CREATE TABLE IF NOT EXISTS New_Sales_contracts (
    sales_id INT PRIMARY KEY AUTO_INCREMENT,
    dateOfContract DATETIME,
    customerName VARCHAR(50),
    customerEmail VARCHAR(100),
    isFinanced BIT,
    vin INT,
    dealership_id INT,
    FOREIGN KEY (dealership_id) REFERENCES New_Dealerships(dealership_id),
    FOREIGN KEY (vin) REFERENCES Another_New_Vehicles(vin)
);


INSERT INTO New_Sales_contracts (dateOfContract, customerName, customerEmail, isFinanced, vin, dealership_id)
VALUES
('2023-01-15 10:30:00', 'John Doe', 'john.doe@example.com', 1, 123456, 1),
('2023-02-20 14:45:00', 'Jane Smith', 'jane.smith@example.com', 0, 789012, 2);


CREATE TABLE IF NOT EXISTS New_Lease_contracts (
    lease_id INT PRIMARY KEY AUTO_INCREMENT,
    dateOfContract DATETIME,
    customerName VARCHAR(50),
    customerEmail VARCHAR(100),
    vin INT,
    dealership_id INT,
    FOREIGN KEY (dealership_id) REFERENCES New_Dealerships(dealership_id),
    FOREIGN KEY (vin) REFERENCES Another_New_Vehicles(vin)
);


INSERT INTO New_Lease_contracts (dateOfContract, customerName, customerEmail, vin, dealership_id)
VALUES
('2023-01-05 11:30:00', 'Emily White', 'emily.white@example.com', 123456, 1),
('2023-02-10 14:20:00', 'Michael Johnson', 'michael.johnson@example.com', 789012, 2);


SELECT * 
FROM New_Dealerships;


SELECT *
FROM Another_New_Vehicles v
JOIN New_Inventory i ON v.vin = i.vin
JOIN New_Dealerships d ON i.dealership_id = d.dealership_id
WHERE d.dealership_id = 2;

 
SELECT *
FROM Another_New_Vehicles
WHERE vin = '789012';


SELECT *
FROM New_Dealerships d 
JOIN New_Inventory i ON d.dealership_id = i.dealership_id
WHERE VIN = '789012';


SELECT *
FROM New_Dealerships d 
JOIN New_Inventory i ON d.dealership_id = i.dealership_id
JOIN Another_New_Vehicles v ON i.vin = v.vin
WHERE v.color = 'Red' AND v.make = 'Honda' AND v.model = 'Civic';


SELECT *
FROM New_Sales_contracts sc
JOIN New_Dealerships d ON sc.dealership_id = d.dealership_id
WHERE sc.dateOfContract >='2023-01-15' AND sc.dateOfContract <= '2023-02-20' AND d.dealership_id = 1;

