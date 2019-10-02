
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
  firstname varchar(255),
  lastname varchar(255) ,
   username varchar(255) ,
   password varchar(255) ,
   emailaddress varchar(255) ,
  PRIMARY KEY (ID)
);
CREATE TABLE if not exists Location (
  ID bigint(20) AUTO_INCREMENT,
  name varchar(255) NOT NULL,
      Address_County varchar(255) ,
  Address_City varchar(255),
   Address_Country varchar(255) ,
   Address_Street_Address varchar(255),
  PRIMARY KEY (ID)
);

CREATE TABLE if not exists Ordeer (
  ID bigint(20) not null  AUTO_INCREMENT,
   Created_At timestamp ,
  Address_City varchar(255) not null,
   Address_Country varchar(255) not null,
      Address_County varchar(255) not null,
   Address_Street_Address varchar(255) not null,
   Customer bigint(20),
   Shipped_From bigint(20),
    FOREIGN KEY (`Customer`)  REFERENCES `Customer` (`ID`),
   FOREIGN KEY(`Shipped_From`)  REFERENCES `Location` (`ID`),
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
CREATE TABLE if not exists Order_Detail (
quantity bigint(20) NOT NULL,
   `product_id` bigint(20) ,
   `ordeer_id` bigint(20) ,
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
