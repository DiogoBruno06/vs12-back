--- DADOS

-- CRIAR DB
criar vemserdbc
use vemserdbc
db.createCollection("alunos")

-- INSERIR DOCS

db.alunos.insertOne({"nome" : "Diogo", "data_nascimento" : ISODate("2004-10-06T12:00:00Z")})
{
  acknowledged: true,
  insertedId: ObjectId("64ec2d31349a623d3415f299")
}

db.alunos.insertOne({"nome" : "Diego", "data_nascimento" : ISODate("1991-02-14T12:00:00Z")})
{
  acknowledged: true,
  insertedId: ObjectId("64ec2d54349a623d3415f29a")
}

db.alunos.insertOne({"nome" : "Luana", "data_nascimento" : ISODate("2004-11-20T12:00:00Z")})
{
  acknowledged: true,
  insertedId: ObjectId("64ec2d6c349a623d3415f29b")
}

 db.alunos.insertOne({"nome" : "Maria", "data_nascimento" : ISODate("2002-09-14T12:00:00Z")})
{
  acknowledged: true,
  insertedId: ObjectId("64ec2d89349a623d3415f29c")
}

db.alunos.insertOne({"nome" : "Breno", "data_nascimento" : ISODate("1999-03-14T12:00:00Z")})
{
  acknowledged: true,
  insertedId: ObjectId("64ec2d9d349a623d3415f29d")
}

db.alunos.insertOne({"nome" : "João Luís", "data_nascimento" : ISODate("2004-10-03T12:00:00Z")})
{
  acknowledged: true,
  insertedId: ObjectId("64ec2dbb349a623d3415f29e")
}

 db.alunos.insertOne({"nome" : "Lucas", "data_nascimento" : ISODate("2004-10-03T12:00:00Z")})
{
  acknowledged: true,
  insertedId: ObjectId("64ec2dcc349a623d3415f29f")
}


-- QUERY

 db.alunos.find({"nome" : /Di.*go/})
[
  {
    _id: ObjectId("64ec2d31349a623d3415f299"),
    nome: 'Diogo',
    data_nascimento: ISODate("2004-10-06T12:00:00.000Z")
  },
  {
    _id: ObjectId("64ec2d54349a623d3415f29a"),
    nome: 'Diego',
    data_nascimento: ISODate("1991-02-14T12:00:00.000Z")
  }
]

 db.alunos.find({"nome": "Luana"})
[
  {
    _id: ObjectId("64ec2d6c349a623d3415f29b"),
    nome: 'Luana',
    data_nascimento: ISODate("2004-11-20T12:00:00.000Z")
  }
]

db.alunos.find({"nome" : /[a-zA-z/.a/})
[
  {
    _id: ObjectId("64ec2d6c349a623d3415f29b"),
    nome: 'Luana',
    data_nascimento: ISODate("2004-11-20T12:00:00.000Z")
  },
  {
    _id: ObjectId("64ec2d89349a623d3415f29c"),
    nome: 'Maria',
    data_nascimento: ISODate("2002-09-14T12:00:00.000Z")
  },
  {
    _id: ObjectId("64ec2dcc349a623d3415f29f"),
    nome: 'Lucas',
    data_nascimento: ISODate("2004-10-03T12:00:00.000Z")
  }
]

