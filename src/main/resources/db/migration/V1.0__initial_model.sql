
CREATE TABLE if not exists Product_Category (
  ID bigint(20) AUTO_INCREMENT,
  name varchar(255) NOT NULL,
  description varchar(255) NOT NULL,
  PRIMARY KEY (ID)
);
CREATE TABLE if not exists Supplier (
  ID bigint(20) AUTO_INCREMENT,
  name varchar(255) NOT NULL,
  PRIMARY KEY (ID)
);
CREATE TABLE if not exists Customer (
  ID bigint(20) AUTO_INCREMENT,
  firstname varchar(255) NOT NULL,
  lastname varchar(255) NOT NULL,
   username varchar(255) NOT NULL,
   password varchar(255) NOT NULL,
   emailaddress varchar(255) NOT NULL,
  PRIMARY KEY (ID)
);
CREATE TABLE if not exists Location (
  ID bigint(20) AUTO_INCREMENT,
  name varchar(255) NOT NULL,
      Address_Couty varchar(255) NOT NULL,
  Address_City varchar(255) NOT NULL,
   Address_Coutry varchar(255) NOT NULL,
   Address_StreetAddress varchar(255) NOT NULL,
  PRIMARY KEY (ID)
);

CREATE TABLE if not exists Ordeer (
  ID bigint(20) AUTO_INCREMENT,
   CreatedAt timestamp DEFAULT NULL,
  Address_City varchar(255) NOT NULL,
   Address_Coutry varchar(255) NOT NULL,
      Address_Couty varchar(255) NOT NULL,
   Address_StreetAddress varchar(255) NOT NULL,
   Customer bigint(20),
   ShippedFrom bigint(20),
    FOREIGN KEY (`Customer`)  REFERENCES `Customer` (`ID`),
   FOREIGN KEY(`ShippedFrom`)  REFERENCES `Location` (`ID`),
  PRIMARY KEY (ID)
);
CREATE TABLE if not exists Reveneu (
  ID bigint(20) AUTO_INCREMENT,
    tdate DATE NOT NULL,
  sum DECIMAL NOT NULL,
  `Location` bigint(20),
   PRIMARY KEY (ID),
   FOREIGN KEY (`Location`)  REFERENCES `Location` (`ID`)
);
CREATE TABLE if not exists Product (
  ID bigint(20) AUTO_INCREMENT,
  name varchar(255) NOT NULL,
  description varchar(255) NOT NULL,
  price DECIMAL NOT NULL,
  weight DOUBLE NOT NULL,
  Category_id bigint(20),
  Supplier bigint(20),
  image_Url varchar(255) ,
  PRIMARY KEY (ID),
 FOREIGN KEY  (`Category_id`) REFERENCES Product_Category(ID),
  FOREIGN KEY  (`Supplier`) REFERENCES Supplier(ID)
);
CREATE TABLE if not exists OrderDetail (
quantity bigint(20) NOT NULL,
   `product_id` bigint(20) DEFAULT NULL,
   `ordeer_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (product_id,ordeer_id),
  FOREIGN KEY (`product_id`) REFERENCES `Product` (`ID`),
 FOREIGN KEY (`ordeer_id`) REFERENCES `Ordeer` (`ID`)
);

CREATE TABLE if not exists Stock (
quantity bigint(20) NOT NULL,
   `product_id` bigint(20) ,
   `location_id` bigint(20) ,
  PRIMARY KEY (product_id,location_id),
 FOREIGN KEY (`product_id`) REFERENCES `Product` (`ID`),
  FOREIGN KEY (`location_id`) REFERENCES `Location` (`ID`)
);
