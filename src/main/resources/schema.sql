CREATE TABLE IF NOT EXISTS `PRODUCTS`
(
    `id`     BIGINT PRIMARY KEY AUTO_INCREMENT,
    `name`  VARCHAR(100) NOT NULL,
    `price` DECIMAL(10, 2) NOT NULL,
    `producer` VARCHAR(100) NOT NULL,
    `country` VARCHAR(30) NOT NULL
);
