DROP DATABASE IF EXISTS pizza;

CREATE DATABASE pizza;
\c pizza

--DROP TABLE IF EXISTS Product;
--DROP TABLE IF EXISTS public."Order";
--DROP TABLE IF EXISTS OrderItem;

CREATE TABLE Product(
	productPK serial PRIMARY KEY,
	name VARCHAR (25) NOT NULL,
	price numeric
);

CREATE TABLE public."Order"(
	orderPK serial PRIMARY KEY,
	email VARCHAR (50) NOT NULL,
	date date
);

CREATE TABLE OrderItem(
	orderItemPK serial PRIMARY KEY,
	orderFK integer NOT NULL,
	productFK integer NOT NULL,
	count integer,
	CONSTRAINT order_item_order_fkey FOREIGN KEY (orderFK)
		REFERENCES Public."Order" (orderPK) MATCH SIMPLE
		ON UPDATE NO ACTION ON DELETE CASCADE,
	CONSTRAINT order_item_product_fkey FOREIGN KEY (productFK)
		REFERENCES Product (productPK) MATCH SIMPLE
		ON UPDATE NO ACTION ON DELETE CASCADE
);

INSERT INTO Product(name, price)
VALUES('Margherita', 18);
INSERT INTO Product (name, price)
VALUES('Prosciutto', 20);
INSERT INTO Product (name, price)
VALUES('Picante', 23);
INSERT INTO Product (name, price)
VALUES('Diablo', 25);
INSERT INTO Product (name, price)
VALUES('Quattro Stagioni', 25);
INSERT INTO Product (name, price)
VALUES('Sprite', 3);
INSERT INTO Product (name, price)
VALUES('Rivella', 3);
INSERT INTO Product (name, price)
VALUES('Mineral', 2);
INSERT INTO Product (name, price)
VALUES('CocaCola', 3);
INSERT INTO public."Order" (email, date)
VALUES('lvonnied@hsr.ch', TO_DATE('11.10.2017', 'DD/MM/YYYY'));
INSERT INTO public."Order" (email, date)
VALUES('dkaiser@hsr.ch', TO_DATE('17.10.2017', 'DD/MM/YYYY'));
INSERT INTO public."Order" (email, date)
VALUES('skeller@hsr.ch', TO_DATE('13.10.2017', 'DD/MM/YYYY'));
INSERT INTO public."Order" (email, date)
VALUES('skurath@hsr.ch', TO_DATE('17.10.2017', 'DD/MM/YYYY'));
INSERT INTO OrderItem (orderFK, productFK, count)
VALUES(1,1,1);
INSERT INTO OrderItem (orderFK, productFK, count)
VALUES(1,9,2);
INSERT INTO OrderItem (orderFK, productFK, count)
VALUES(2,4,1);
INSERT INTO OrderItem (orderFK, productFK, count)
VALUES(3,5,1);
INSERT INTO OrderItem (orderFK, productFK, count)
VALUES(3,7,3);
INSERT INTO OrderItem (orderFK, productFK, count)
VALUES(4,3,1);
INSERT INTO OrderItem (orderFK, productFK, count)
VALUES(4,8,1);