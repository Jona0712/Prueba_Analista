USE master
GO
CREATE DATABASE Examen_CHN_Jonnathan
GO
USE Examen_CHN_Jonnathan
GO
CREATE TABLE Cheque(
	Id_Cheque int PRIMARY KEY IDENTITY(1,1) NOT NULL,
	Id_Chequera int NOT NULL,
	Id_Estado int NOT NULL,
	Monto float NOT NULL,
	Fecha_Cheque date NOT NULL,
	Cuenta_acreditar int NOT NULL)
GO
CREATE TABLE Chequera(
	Id_Chequera int PRIMARY KEY IDENTITY(1,1) NOT NULL,
	Id_Cuenta int NOT NULL,
	Cantidad_Cheque int NOT NULL,
	Id_Estado int NOT NULL
) 
GO
CREATE TABLE Cliente(
	Id_Cliente int PRIMARY KEY IDENTITY(1,1) NOT NULL,
	Nombre varchar(100) NOT NULL,
	Apellido varchar(100) NOT NULL,
	Numero_Identificacion varchar(50) NOT NULL,
	Fecha_Nacimiento date NOT NULL,
	Direccion varchar(110) NOT NULL,
	Correo_Electronico varchar (100) NOT NULL,
	Telefono varchar(50) NOT NULL,
	Estado char(1) NOT NULL
) 
GO
CREATE TABLE Cuenta(
	Id_Cuenta int PRIMARY KEY IDENTITY(1,1) NOT NULL,
	Id_Cliente int NOT NULL,
	Tipo_Cuenta varchar(50) NOT NULL,
	Monto float NOT NULL,
	Id_EstadoCuenta int NOT NULL
)
GO
CREATE TABLE Estado(
	id_Estado int PRIMARY KEY IDENTITY(1,1) NOT NULL,
	nombre_estado varchar(50) NOT NULL,
	Is_Cheque char(1) NOT NULL
) 
GO
CREATE TABLE Modificacion_Cheque(
	Id_Registro int PRIMARY KEY IDENTITY(1,1) NOT NULL,
	Motivo_Actualizacion varchar(150) NOT NULL,
	Fecha_Actualizacion date NOT NULL,
	Id_Cheque int NOT NULL
)
GO
CREATE TABLE Modificacion_Chequera(
	Id_registro int IDENTITY(1,1) NOT NULL,
	Motivo_Actualizacion varchar(150) NOT NULL,
	Fecha_Actualizacion date NOT NULL,
	Id_Chequera int NOT NULL
) 
GO
CREATE TABLE Modificacion_Cuenta(
	Id_registro int IDENTITY(1,1) NOT NULL,
	Motivo_Actualizacion varchar(150) NOT NULL,
	Fecha_Actualizacion date NOT NULL,
	Id_Cuenta int NOT NULL
)
GO
ALTER TABLE Cheque  ADD  CONSTRAINT FK_Cheque_Chequera FOREIGN KEY(Id_Chequera)
REFERENCES Chequera (Id_Chequera)
GO
ALTER TABLE Cheque  ADD  CONSTRAINT FK_Cheque_Cuenta FOREIGN KEY(Cuenta_acreditar)
REFERENCES Cuenta (Id_Cuenta)
GO
ALTER TABLE Chequera  ADD  CONSTRAINT FK_Chequera_Cuenta FOREIGN KEY(Id_Cuenta)
REFERENCES Cuenta (Id_Cuenta)
GO
ALTER TABLE Chequera   ADD  CONSTRAINT FK_Chequera_Estado FOREIGN KEY(Id_Estado)
REFERENCES Estado (id_Estado)
GO
ALTER TABLE Cuenta  ADD  CONSTRAINT FK_Cuenta_Cliente FOREIGN KEY(Id_Cliente)
REFERENCES Cliente (Id_Cliente)
GO
ALTER TABLE Cuenta  ADD  CONSTRAINT FK_Cuenta_Estado FOREIGN KEY(Id_EstadoCuenta)
REFERENCES Estado (id_Estado)
GO
ALTER TABLE Modificacion_Cheque  ADD  CONSTRAINT FK_Modificacion_Cheque_Cheque FOREIGN KEY(Id_Cheque)
REFERENCES Cheque (Id_Cheque)
GO
ALTER TABLE Modificacion_Chequera ADD  CONSTRAINT FK_Modificacion_Chequera_Chequera FOREIGN KEY(Id_Chequera)
REFERENCES Chequera (Id_Chequera)
GO
ALTER TABLE Modificacion_Cuenta  ADD  CONSTRAINT FK_Modificacion_Cuenta_Cuenta FOREIGN KEY(Id_Cuenta)
REFERENCES Cuenta (Id_Cuenta)
GO
ALTER TABLE Cuenta  ADD  CONSTRAINT CK_Cuenta CHECK  ((Tipo_Cuenta='Monetaria' OR Tipo_Cuenta='Ahorro'))
GO
INSERT INTO ESTADO VALUES('Activa',0)
GO
INSERT INTO ESTADO VALUES('Bloqueada',0)
GO
INSERT INTO ESTADO VALUES('Desactualizada',0)
GO 
INSERT INTO ESTADO VALUES('EN CIRCULACION',1)
GO
INSERT INTO ESTADO VALUES('Cambiado',1)
GO
INSERT INTO ESTADO VALUES('Reportado',1)
