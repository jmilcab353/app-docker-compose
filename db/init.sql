CREATE TABLE IF NOT EXISTS products (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    price DOUBLE NOT NULL,
    quantity INT NOT NULL
);

INSERT INTO products (title, price, quantity) VALUES 
    ('iPhone 11 Pro', 799.99, 10),
    ('MacBook Pro', 999.99, 5),
    ('Apple Watch', 399.99, 2),
    ('AirPods', 69.99, 10),
    ('Beats Solo 3', 299.99, 1);

COMMIT;