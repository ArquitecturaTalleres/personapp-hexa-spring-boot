use persona_db

// Colección: persona
db.persona.insertMany([
  {
    _id: NumberInt(123456789),
    nombre: "Pepe",
    apellido: "Perez",
    genero: "M",
    edad: NumberInt(30),
    _class: "co.edu.javeriana.as.personapp.mongo.document.PersonaDocument"
  },
  {
    _id: NumberInt(987654321),
    nombre: "Pepito",
    apellido: "Perez",
    genero: "M",
    _class: "co.edu.javeriana.as.personapp.mongo.document.PersonaDocument"
  },
  {
    _id: NumberInt(321654987),
    nombre: "Pepa",
    apellido: "Juarez",
    genero: "F",
    edad: NumberInt(30),
    _class: "co.edu.javeriana.as.personapp.mongo.document.PersonaDocument"
  },
  {
    _id: NumberInt(147258369),
    nombre: "Pepita",
    apellido: "Juarez",
    genero: "F",
    edad: NumberInt(10),
    _class: "co.edu.javeriana.as.personapp.mongo.document.PersonaDocument"
  },
  {
    _id: NumberInt(963852741),
    nombre: "Fede",
    apellido: "Perez",
    genero: "M",
    edad: NumberInt(18),
    _class: "co.edu.javeriana.as.personapp.mongo.document.PersonaDocument"
  }
]);

// Colección: profesion
db.profesion.insertMany([
  {
    _id: NumberInt(1),
    nom: "Ingeniero de Software",
    des: "Diseña y desarrolla aplicaciones informáticas",
    _class: "co.edu.javeriana.as.personapp.mongo.document.ProfesionDocument"
  },
  {
    _id: NumberInt(2),
    nom: "Médico General",
    des: "Atiende consultas médicas generales",
    _class: "co.edu.javeriana.as.personapp.mongo.document.ProfesionDocument"
  },
  {
    _id: NumberInt(3),
    nom: "Abogado",
    des: "Representa y asesora legalmente a personas y empresas",
    _class: "co.edu.javeriana.as.personapp.mongo.document.ProfesionDocument"
  },
  {
    _id: NumberInt(4),
    nom: "Profesor",
    des: "Imparte clases en instituciones educativas",
    _class: "co.edu.javeriana.as.personapp.mongo.document.ProfesionDocument"
  },
  {
    _id: NumberInt(5),
    nom: "Diseñador Gráfico",
    des: "Diseña piezas visuales y gráficas",
    _class: "co.edu.javeriana.as.personapp.mongo.document.ProfesionDocument"
  }
]);

// Colección: telefono
db.telefono.insertMany([
  {
    _id: "3001112233",
    oper: "Claro",
    duenio: NumberInt(123456789),
    _class: "co.edu.javeriana.as.personapp.mongo.document.TelefonoDocument"
  },
  {
    _id: "3002223344",
    oper: "Movistar",
    duenio: NumberInt(987654321),
    _class: "co.edu.javeriana.as.personapp.mongo.document.TelefonoDocument"
  },
  {
    _id: "3003334455",
    oper: "Tigo",
    duenio: NumberInt(321654987),
    _class: "co.edu.javeriana.as.personapp.mongo.document.TelefonoDocument"
  },
  {
    _id: "3004445566",
    oper: "Claro",
    duenio: NumberInt(147258369),
    _class: "co.edu.javeriana.as.personapp.mongo.document.TelefonoDocument"
  },
  {
    _id: "3005556677",
    oper: "Wom",
    duenio: NumberInt(963852741),
    _class: "co.edu.javeriana.as.personapp.mongo.document.TelefonoDocument"
  }
]);

// Colección: estudios
db.estudios.insertMany([
  {
    id_prof: NumberInt(1),
    cc_per: NumberInt(123456789),
    fecha: ISODate("2010-06-15T00:00:00Z"),
    univer: "Universidad Javeriana",
    _class: "co.edu.javeriana.as.personapp.mongo.document.EstudioDocument"
  },
  {
    id_prof: NumberInt(2),
    cc_per: NumberInt(987654321),
    fecha: ISODate("2015-08-20T00:00:00Z"),
    univer: "Universidad Nacional",
    _class: "co.edu.javeriana.as.personapp.mongo.document.EstudioDocument"
  },
  {
    id_prof: NumberInt(3),
    cc_per: NumberInt(321654987),
    fecha: ISODate("2012-07-10T00:00:00Z"),
    univer: "Universidad de los Andes",
    _class: "co.edu.javeriana.as.personapp.mongo.document.EstudioDocument"
  },
  {
    id_prof: NumberInt(4),
    cc_per: NumberInt(147258369),
    fecha: ISODate("2020-01-01T00:00:00Z"),
    univer: "Colegio San José",
    _class: "co.edu.javeriana.as.personapp.mongo.document.EstudioDocument"
  },
  {
    id_prof: NumberInt(5),
    cc_per: NumberInt(963852741),
    fecha: ISODate("2022-09-05T00:00:00Z"),
    univer: "Universidad del Valle",
    _class: "co.edu.javeriana.as.personapp.mongo.document.EstudioDocument"
  }
]);
