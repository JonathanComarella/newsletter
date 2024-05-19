CREATE TABLE news (
    id SERIAL PRIMARY KEY,
    title VARCHAR(200) NOT NULL,
    description VARCHAR(900) NOT NULL,
    link VARCHAR(1000),
    processed DATE
);
