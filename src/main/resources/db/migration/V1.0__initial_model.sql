
CREATE TABLE ProductCategory (
  ID bigint(20) NOT NULL,
  name varchar(255) NOT NULL,
  description varchar(255) NOT NULL,
  PRIMARY KEY (ID)
);
CREATE TABLE Supplier (
  ID bigint(20) NOT NULL,
  name varchar(255) NOT NULL,
  PRIMARY KEY (ID)
);
CREATE TABLE Customer (
  ID bigint(20) NOT NULL,
  firstname varchar(255) NOT NULL,
  lastname varchar(255) NOT NULL,
   username varchar(255) NOT NULL,
   password varchar(255) NOT NULL,
   emailaddress varchar(255) NOT NULL,
  PRIMARY KEY (ID)
);
CREATE TABLE Location (
  ID bigint(20) NOT NULL,
  name varchar(255) NOT NULL,
      Address_Couty varchar(255) NOT NULL,
  Address_City varchar(255) NOT NULL,
   Address_Coutry varchar(255) NOT NULL,
   Address_StreetAddress varchar(255) NOT NULL,
  PRIMARY KEY (ID)
);

CREATE TABLE Ordeer (
  ID bigint(20) NOT NULL,
   CrearedAt datetime DEFAULT NULL,
  Address_City varchar(255) NOT NULL,
   Address_Coutry varchar(255) NOT NULL,
    Address_Couty varchar(255) NOT NULL,
     Customer bigint(20) NOT NULL  REFERENCES `Customer` (`ID`),
   ShippedFrom bigint(20) NOT NULL  REFERENCES `Location` (`ID`),
   Address_StreetAddress varchar(255) NOT NULL,
  PRIMARY KEY (ID)
);
CREATE TABLE Reveneu (
  ID bigint(20) NOT NULL,
    tdate datetime NOT NULL,
  sum bigint(20) NOT NULL,
   PRIMARY KEY (ID),
     `Location` bigint(20) DEFAULT NULL REFERENCES `Location` (`ID`)
);
CREATE TABLE Product (
  ID bigint(20) NOT NULL,
  name varchar(255) NOT NULL,
  description varchar(255) NOT NULL,
  price bigint(20) DEFAULT NULL,
  weight bigint(20) DEFAULT NULL,
  imageUrl varchar(255) DEFAULT NULL,
  PRIMARY KEY (ID),
 Category bigint(20) NOT NULL REFERENCES ProductCategory(ID),
  Supplier bigint(20) NOT NULL REFERENCES Supplier(ID)
);

CREATE TABLE OrderDetail (
quantity bigint(20) NOT NULL,
  `ID` bigint(20) NOT NULL,
   `Product` bigint(20) DEFAULT NULL,
   `Ordeer` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  FOREIGN KEY (`Product`) REFERENCES `Product` (`ID`),
 FOREIGN KEY (`Ordeer`) REFERENCES `Ordeer` (`ID`)
);

CREATE TABLE Stock (
quantity bigint(20) NOT NULL,
 `ID` bigint(20) NOT NULL,
   `Product` bigint(20) DEFAULT NULL,
   `Location` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ID`),
 FOREIGN KEY (`Product`) REFERENCES `Product` (`ID`),
  FOREIGN KEY (`Location`) REFERENCES `Location` (`ID`)
);
