-- mariadb init docker

-- Crear base de datos
CREATE DATABASE IF NOT EXISTS persona_db;
USE persona_db;

-- Tabla persona
CREATE TABLE persona (
    cc INT NOT NULL,
    nombre VARCHAR(45) NOT NULL,
    apellido VARCHAR(45) NOT NULL,
    genero CHAR(1) NOT NULL,
    edad INT,
    PRIMARY KEY (cc)
);

-- Tabla profesion
CREATE TABLE profesion (
    id INT NOT NULL,
    nom VARCHAR(90) NOT NULL,
    des TEXT,
    PRIMARY KEY (id)
);

-- Tabla telefono
CREATE TABLE telefono (
    num VARCHAR(15) NOT NULL,
    oper VARCHAR(45) NOT NULL,
    duenio INT NOT NULL,
    PRIMARY KEY (num),
    FOREIGN KEY (duenio) REFERENCES persona(cc) ON DELETE CASCADE ON UPDATE CASCADE
);

-- Tabla estudios
CREATE TABLE estudios (
    id_prof INT NOT NULL,
    cc_per INT NOT NULL,
    fecha DATE,
    univer VARCHAR(50),
    PRIMARY KEY (id_prof, cc_per),
    FOREIGN KEY (id_prof) REFERENCES profesion(id) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (cc_per) REFERENCES persona(cc) ON DELETE CASCADE ON UPDATE CASCADE
);
