SET search_path TO crm_jee;

INSERT INTO customers (lastname, firstname, company, mail, phone, mobile, notes, active) VALUES ('JONES', 'Indiana', 'Université de Chicago', 'indiana.jonas@univ-chicago.com', '0222222222', '0666666666', 'Les notes d''Indiana', true);

INSERT INTO customers (lastname, firstname, company, mail, phone, mobile, notes, active) VALUES ('KENOBI', 'Obi-Wan', 'Jedis', 'obiwan.kenobi@jedis.com', '0222222222', '0666666666', 'Les notes d''Obi Wan', true);

INSERT INTO customers (lastname, firstname, company, mail, phone, mobile, notes, active) VALUES ('MCCLANE', 'John', 'NYPD', 'john.mcclane@nypd.com', '0222222222', '0666666666', 'Les notes de John', false);

INSERT INTO customers (lastname, firstname, company, mail, phone, mobile, notes, active) VALUES ('MCFLY', 'Marty', 'DOC', 'marty.mcfly@doc.com', 0222222222, NULL, 'Les notes de Marty', false);

INSERT INTO orders (label, adr_et, number_of_days, tva, status, type, notes) VALUES ('Formation Java', 450.0, 5, 20, 'En cours', 'Forfait', 'Test');

INSERT INTO orders (label, adr_et, number_of_days, tva, status, type, notes) VALUES ('Formation Spring', 450.0, 3, 20.0, 'En attente', 'Forfait', 'Test');

INSERT INTO orders (label, adr_et, number_of_days, tva, status, type, notes) VALUES ('Formation Jedi', 1500.0, 2, 20.0, 'Payée', 'Forfait', 'Notes sur la formation');

INSERT INTO users (username, password, mail, grants) VALUES ('toto', '1234', 'toto@titi.com', 'ADMIN');