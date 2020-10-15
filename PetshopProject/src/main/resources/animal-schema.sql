DROP TABLE `animal`;

CREATE TABLE animal (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    givenname VARCHAR(255),
    commonname VARCHAR(255),
    type VARCHAR(255),
    price INTEGER NOT NULL,
    sex VARCHAR(255),
    colour VARCHAR(255),
    arrival VARCHAR(255)
);