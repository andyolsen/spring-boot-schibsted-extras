DROP TABLE employee IF EXISTS;

CREATE TABLE employee  (
    id INT AUTO_INCREMENT PRIMARY KEY,
    firstname VARCHAR,
    lastname VARCHAR,
    salary BIGINT
);