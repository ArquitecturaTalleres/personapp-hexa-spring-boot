-- Inserción de datos en la tabla persona
INSERT INTO
    `persona_db`.`persona` (`cc`, `nombre`, `apellido`, `genero`, `edad`)
VALUES
    (123456789, 'Pepe', 'Perez', 'M', 30),
    (987654321, 'Pepito', 'Perez', 'M', NULL),
    (321654987, 'Pepa', 'Juarez', 'F', 30),
    (147258369, 'Pepita', 'Juarez', 'F', 10),
    (963852741, 'Fede', 'Perez', 'M', 18);

-- Inserción de datos en la tabla profesion
INSERT INTO
    `persona_db`.`profesion` (`id`, `nom`, `des`)
VALUES
    (1, 'Ingeniero de Software', 'Diseña y desarrolla aplicaciones informáticas'),
    (2, 'Médico General', 'Atiende consultas médicas generales'),
    (3, 'Abogado', 'Representa y asesora legalmente a personas y empresas'),
    (4, 'Profesor', 'Imparte clases en instituciones educativas'),
    (5, 'Diseñador Gráfico', 'Diseña piezas visuales y gráficas');

-- Inserción de datos en la tabla telefono
INSERT INTO
    `persona_db`.`telefono` (`num`, `oper`, `duenio`)
VALUES
    ('3001112233', 'Claro', 123456789),
    ('3002223344', 'Movistar', 987654321),
    ('3003334455', 'Tigo', 321654987),
    ('3004445566', 'Claro', 147258369),
    ('3005556677', 'Wom', 963852741);

-- Inserción de datos en la tabla estudios
INSERT INTO
    `persona_db`.`estudios` (`id_prof`, `cc_per`, `fecha`, `univer`)
VALUES
    (1, 123456789, '2010-06-15', 'Universidad Javeriana'),
    (2, 987654321, '2015-08-20', 'Universidad Nacional'),
    (3, 321654987, '2012-07-10', 'Universidad de los Andes'),
    (4, 147258369, '2020-01-01', 'Colegio San José'),
    (5, 963852741, '2022-09-05', 'Universidad del Valle');
