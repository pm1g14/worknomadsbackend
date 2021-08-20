DROP TABLE IF EXISTS employee;
DROP TABLE IF EXISTS business_partner;

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

INSERT INTO business_partner (name, address, email, phone, wallet_address) VALUES
('Sonovate', 'Cardiff Castle street', 'sono@sono.co.uk', '+44023456437', '0x45316062B2347659F19A01765f0e7af05ED34a3d');

INSERT INTO employee (name, surname, email, address, country_of_residence, phone_num, wallet_address) VALUES
('Aris', 'Fanaras', 'aris@fan.co.uk', 'Piercefield', 'Greece', '+44023456437', '0xCF6999A79411D4Ed73aA0cCa43fE2982cFA68e65');
