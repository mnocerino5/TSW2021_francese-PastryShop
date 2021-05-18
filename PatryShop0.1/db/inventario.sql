DROP DATABASE IF EXISTS inventario;
CREATE DATABASE inventario;
USE inventario;

DROP TABLE IF EXISTS product;

CREATE TABLE product (	
  code int primary key AUTO_INCREMENT,
  name char(20) not null,
  description char(100),
  price int default 0,
  quantity int default 0
);

INSERT INTO product values (1,"Panettone","Panettone classico a lievitazione naturale",30,5);
INSERT INTO product values (2,"Colomba","Colomba classico a lievitazione naturale",30,13);
INSERT INTO product values (3,"Torta profiteroles","Insieme di bigne al forno ripieni di panna e ricoperti di cioccolato fondete",20,4);
INSERT INTO product values (4,"Torta millefoglie","Sfoglia ripiena di crema chantilly e amarena",20,11);
INSERT INTO product values (5,"Cornetto bicolore","Cornetto a lievitazione naturale",2,3);
