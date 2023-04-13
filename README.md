create table products(
id INT NOT NULL PRIMARY KEY,
product_name VARCHAR(50),
product_cost DECIMAL(10, 2)
);

insert into products(id, product_name, product_cost)
values
(1, 'Milo', 2.50), 
(2, 'Milk', 4.00),
(3, 'Potato chips', 1.80),
(4, 'Bread', 3.10),
(5, 'Apple', 0.50),
(6, 'Panadol', 7.80),
(7, 'Tissue paper', 13.99);

create table orders(
    order_id INT AUTO_INCREMENT PRIMARY KEY,
    order_date DATE,
    customer_name VARCHAR(128),
    ship_address VARCHAR(128),
    notes TEXT,
    tax DECIMAL (2,2) DEFAULT 0.05
);

create table order_details(
    id INT AUTO_INCREMENT PRIMARY KEY,
    product VARCHAR(128),
    unit_price DECIMAL(4, 2),
    discount DECIMAL(2,1) DEFAULT 1.0,
    tax DECIMAL (2,2) DEFAULT 0.05,
    quantity INT,
    order_id INT, 
    FOREIGN KEY (order_id) REFERENCES orders(order_id)

);