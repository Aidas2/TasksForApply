DROP TABLE IF EXISTS products;
CREATE TABLE products (
   id BIGINT(20) NOT NULL AUTO_INCREMENT,
   title varchar(256),
   description varchar(256),
   primary key (id)
);

DROP TABLE IF EXISTS responses;
CREATE TABLE responses (
   id BIGINT(20) NOT NULL,
   age_range varchar(256),
   is_student boolean,
   incomeRange varchar(256),
   primary key (id)
);
