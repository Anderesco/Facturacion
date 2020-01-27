create database Facturacion;

use facturacion;

CREATE TABLE Cliente 
(
  ID 				INT 		NOT NULL AUTO_INCREMENT,
  Nombre 			VARCHAR(20) NULL,
  ApellidoPaterno   VARCHAR(20) NULL,
  ApellidoMaterno 	VARCHAR(20) NULL,
  DNI 				VARCHAR(8)  NULL,
  RUC				VARCHAR(11) NULL,
  Edad 				INT			NULL,
  Celular			VARCHAR(9) NULL,
  
  PRIMARY KEY (ID)
);

CREATE TABLE Comprobante 
(
  ID 				INT 		NOT NULL  AUTO_INCREMENT,
  IDCliente 		INT 		NULL,
  IDSede 			INT 		NULL,
  NumeroComprobante INT 		NULL,
  FechaCreacion 	DATETIME 	NULL,
  Estado 			VARCHAR(10) NULL,
  FechaEmision 		DATETIME 	NULL,
  MontoTotal 		FLOAT 		NULL,
  
  PRIMARY KEY (ID)
);

CREATE TABLE Sede 
(
  ID 		INT 		NOT NULL   AUTO_INCREMENT,
  Nombre 	VARCHAR(45) NULL,
  Direccion VARCHAR(50) NULL,
  Telefono 	VARCHAR(7) 	NULL,
  
  PRIMARY KEY (ID)
);

CREATE TABLE DetalleComprobante 
(
  ID 		  	INT NOT NULL 	AUTO_INCREMENT,
  IDComprobante INT NOT NULL,
  IDLibro 	  	INT NULL,
  Cantidad 	  	INT NULL,
  
  PRIMARY KEY (ID)
);

CREATE TABLE Libro
(
  ID 			 INT 		 NOT NULL  AUTO_INCREMENT,
  Nombre 		 VARCHAR(50) NULL,
  PrecioUnitario FLOAT 		 NULL,
  Autor 		 VARCHAR(30) NULL,
  Anio 			 INT 		 NULL,
  
  PRIMARY KEY (ID)
);

ALTER TABLE DetalleComprobante ADD CONSTRAINT fk_libro   FOREIGN KEY (IDLibro) REFERENCES Libro(ID);
ALTER TABLE Comprobante  	   ADD CONSTRAINT fk_cliente FOREIGN KEY (IDCliente) REFERENCES Cliente(ID);
ALTER TABLE Comprobante 	   ADD CONSTRAINT fk_sede    FOREIGN KEY (IDSede)    REFERENCES Sede (ID);
ALTER TABLE Detallecomprobante ADD CONSTRAINT fk_detalle FOREIGN KEY (IDComprobante) REFERENCES Comprobante(ID);


