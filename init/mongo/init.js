// mongodb init docker
db = db.getSiblingDB("persona_db");

db.createUser({
  user: "persona_db",
  pwd: "persona_db",
  roles: [{ role: "readWrite", db: "persona_db" }],
});

db.createCollection("persona");
db.createCollection("telefono");
db.createCollection("estudios");
db.createCollection("profesion");

db.telefono.createIndex({ primaryDuenio: 1 });
db.estudios.createIndex({ primaryPersona: 1 });
db.estudios.createIndex({ primaryProfesion: 1 });
db.profesion.createIndex({ id: 1 }, { unique: true });
db.persona.createIndex({ id: 1 }, { unique: true });
