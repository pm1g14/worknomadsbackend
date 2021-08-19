
Skip to content
Pulls
Issues
Marketplace
Explore
@arisfan87
pm1g14 /
worknomadsbackend
Private

2
0

    1

Code
Issues
Pull requests
Actions
Projects
Security

    Insights

worknomadsbackend/src/main/resources/schema.sql
arisf Added contracts repo.
Latest commit 7a26467 1 hour ago
History
0 contributors
48 lines (41 sloc) 2.04 KB
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

CREATE TABLE contracts (
id INTEGER NOT NULL AUTO_INCREMENT,
address VARCHAR(250) NOT NULL,
contract_expiry VARCHAR(250) NOT NULL,
gross_salary VARCHAR(250) NOT NULL,
remote_location VARCHAR(250) NOT NULL,
payment_installments VARCHAR(250) NOT NULL,
payment_term VARCHAR(250) NULL,
balance_unit VARCHAR(250) NULL,
employee_wallet_address VARCHAR(250) NOT NULL,
business_partner_wallet_address VARCHAR(250) NOT NULL,
PRIMARY KEY (id)
);

INSERT INTO business_partner (name, address, email, phone, wallet_address) VALUES
('Sonovate', 'Cardiff Castle street', 'sono@sono.co.uk', '+44023456437', '0x45316062B2347659F19A01765f0e7af05ED34a3d');

INSERT INTO employee (name, surname, email, address, country_of_residence, phone_num, wallet_address) VALUES
('Aris', 'Fanaras', 'aris@fan.co.uk', 'Piercefield', 'Greece', '+44023456437', '0xCF6999A79411D4Ed73aA0cCa43fE2982cFA68e65');

INSERT INTO contracts (address, contract_expiry, gross_salary, remote_location, payment_installments, payment_term, balance_unit, employee_wallet_address, business_partner_wallet_address) VALUES
('0x9646fc6ee1b3bf193ca2bcd0d167e0aa2c6244b0', '2025-01-01T17:16:40', '200000', 'Greece', '2', '', '', '0xCF6999A79411D4Ed73aA0cCa43fE2982cFA68e65', '0x45316062B2347659F19A01765f0e7af05ED34a3d'),
('0x9646fc6ee1b3bf193ca2bcd0d167e0aa2c6244b1', '2025-01-01T17:16:40', '400000', 'Greece', '2', '', '', '0xCF6999A79411D4Ed73aA0cCa43fE2982cFA68e65', '0x45316062B2347659F19A01765f0e7af05ED34a3d')
