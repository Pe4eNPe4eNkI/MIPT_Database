CREATE TABLE client (
    client_id BIGSERIAL NOT NULL PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    second_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    hb_data DATE NOT NULL ,
    passport_number VARCHAR(10) NOT NULL CHECK (LENGTH(passport_number) == 10), 
    phone_number VARCHAR(11) NOT NULL CHECK (LENGTH(phone_number) == 11)
);

CREATE TABLE credit (
    credit_id BIGSERIAL NOT NULL PRIMARY KEY,
    client_id BIGINT NOT FOREIGN KEY NULL REFERENCES client,
    opening_date DATE CHECK (closing_date > opening_date),
    closing_date DATE CHECK (closing_date > opening_date),
    credit_summ INTEGER NOT NULL CHECK (credit_summ > 0),
    credit_name VARCHAR(30) NOT NULL UNIQUE REFERENCES credit_type
);

CREATE TABLE deposit (
    deposit_id BIGSERIAL NOT NULL PRIMARY KEY,
    client_id BIGINT NOT NULL FOREIGN KEY REFERENCES client,
    opening_date DATE CHECK (closing_date > opening_date),
    closing_date DATE CHECK (closing_date > opening_date),
    deposit_summ INTEGER NOT NULL CHECK (deposit_summ > 0),
    deposit_name VARCHAR(30) NOT NULL UNIQUE REFERENCES deposit_type
);

CREATE TABLE currency_type (
currency_id BIGSERIAL NOT NULL,
currency_name VARCHAR(20) NOT NULL UNIQUE
);

CREATE TABLE credit_type (
    credit_id BIGSERIAL NOT NULL PRIMARY KEY,
    credit_name VARCHAR(30) NOT NULL UNIQUE,
    percent FLOAT CHECK (percent > 0) REFERENCES key_rate,
    commission FLOAT NOT NULL,
    currency_id INTEGER NOT NULL,
    max_summ INTEGER NOT NULL
);

CREATE TABLE deposit_type (
    deposit_id BIGSERIAL NOT NULL PRIMARY KEY,
    deposit_name VARCHAR(30) NOT NULL UNIQUE,
    percent FLOAT CHECK (percent > 0),
    replenishment FLOAT NOT NULL,
    currency_id INTEGER NOT NULL,
    min_summ INTEGER NOT NULL
);

CREATE TABLE key_rate( 
    percent FLOAT NOT NULL,
    rate_data DATE NOT NULL
);