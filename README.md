# AD_Veterinaria
A Java-based project developed with Maven, MySQL Connector, XAMP Control Panel,and Java Swing, implementing a CRUD (Create, Read, Update, Delete) system for managing entities. The application features a Back-End built with Java to handle business logic and database interactions, and a Front-End was created with Java Swing for an intuitive graphical user interface.

A MVC model was used for this project.

SQL Query to create the data base:

DROP DATABASE IF EXISTS veterinaria;
CREATE DATABASE veterinaria;
use veterinaria;
CREATE TABLE paciente(
   idMascota int AUTO_INCREMENT PRIMARY KEY   ,
    aliasMascota varchar (100) ,
	especie varchar (100) ,
    raza varchar (100) ,
    colorPelo varchar (100) ,
    fechaNacimiento date ,
    vacunaciones int
    );
    
CREATE TABLE peso(
    idPeso int AUTO_INCREMENT PRIMARY KEY ,
    idMascota int,
    fecha date,
    peso double,
    FOREIGN KEY (idMascota) REFERENCES paciente(idMascota)
);

CREATE TABLE vacuna(
    idVacuna int AUTO_INCREMENT PRIMARY KEY,
    idMascota int,
    fecha date,
    enfermedad varchar (100),
    fechaProxima date,
    FOREIGN KEY (idMascota) REFERENCES paciente(idMascota)
);
