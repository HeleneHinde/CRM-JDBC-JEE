SET search_path TO crm_jee;

DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS orders;
DROP TABLE IF EXISTS customers;

CREATE TABLE customers(id SERIAL NOT NULL, 
								lastname VARCHAR(100) NOT NULL, 
                                firstname VARCHAR(100) NOT NULL,
                                company VARCHAR(200) NOT NULL,
                                mail VARCHAR(255) NOT NULL,
                                phone VARCHAR(15) NOT NULL,
                                mobile VARCHAR(15),
                                notes VARCHAR(255),
                                active BOOLEAN DEFAULT TRUE,
                                PRIMARY KEY (id));

CREATE TABLE orders(id SERIAL NOT NULL,
									customer_id INT,
                                    label VARCHAR(100),
                                    adr_et DECIMAL,
                                    number_of_days DECIMAL,
                                    tva DECIMAL,
                                    status VARCHAR(30),
                                    type VARCHAR(100),
                                    notes VARCHAR(255),
                                    PRIMARY KEY (id),
                                    FOREIGN KEY (customer_id) REFERENCES customers(id));                                    

CREATE TABLE users (id SERIAL NOT NULL,
									   username VARCHAR(30),
                                       password VARCHAR(255),
                                       mail VARCHAR(255),
                                       grants VARCHAR(20),
                                       PRIMARY KEY(id));