DROP TABLE IF EXISTS employee;
DROP TABLE IF EXISTS business_partner;
DROP TABLE IF EXISTS smart_contract;

CREATE TABLE business_partner (
id INTEGER NOT NULL AUTO_INCREMENT,
address VARCHAR(250) NOT NULL,
email VARCHAR(250) NOT NULL,
name VARCHAR(250) NOT NULL,
phone VARCHAR(250) NOT NULL,
wallet_address VARCHAR(250) NOT NULL,
PRIMARY KEY (wallet_address)
);

CREATE TABLE employee (
id INTEGER NOT NULL AUTO_INCREMENT,
name VARCHAR(250) NOT NULL,
surname VARCHAR(250) NOT NULL,
email VARCHAR(250) NOT NULL,
address VARCHAR(250) NOT NULL,
country_of_residence VARCHAR(250) NOT NULL,
phone_num VARCHAR(250) NOT NULL,
wallet_address VARCHAR(250) NOT NULL,
PRIMARY KEY (wallet_address)
);


CREATE TABLE smart_contract (
id INTEGER NOT NULL AUTO_INCREMENT,
address VARCHAR(250) NOT NULL,
status VARCHAR(250) NOT NULL,
business_partner_wallet_address VARCHAR(250) NOT NULL,
PRIMARY KEY (address)
);

INSERT INTO business_partner (name, address, email, phone, wallet_address) VALUES
('Sonovate', 'Cardiff Castle street', 'sono@sono.co.uk', '+44023456437', '0x45316062B2347659F19A01765f0e7af05ED34a3d');

INSERT INTO employee (name, surname, email, address, country_of_residence, phone_num, wallet_address) VALUES
('Aris', 'Fanaras', 'aris@fan.co.uk', 'Piercefield', 'Greece', '+44023456437', '0xCF6999A79411D4Ed73aA0cCa43fE2982cFA68e65'),
('Panos', 'MAvr', 'panosmavr@mavr.co.uk', 'London', 'Canary', '+12313123', '0xCF6999A79411D4Ed73aA0cCa43fE2982cFA68e66');

INSERT INTO smart_contract (address, status, business_partner_wallet_address) VALUES
('0x9646fc6ee1b3bf193ca2bcd0d167e0aa2c6244b0', 'active', '0x45316062B2347659F19A01765f0e7af05ED34a3d');