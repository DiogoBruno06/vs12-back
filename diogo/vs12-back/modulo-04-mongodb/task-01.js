--- DADOS

-- CRIAR DB
criar vemserdbc
use vemserdbc
db.createCollection("alunos")

-- INSERIR DOCS

db.alunos.insertOne({"nome" : "Breno Franco", "data_nascimento" : new Date(2000-10-12)})
{
    acknowledged: true,
        insertedId: ObjectId("64e58f0d8cf9ea4e38d8e90f")
}

db.alunos.insertOne({"nome" : "Cayo Hollanda", "data_nascimento" : new Date(1998-06-10)})
{
    acknowledged: true,
        insertedId: ObjectId("64e58f2c8cf9ea4e38d8e910")
}

db.alunos.insertOne({"nome" : "João Luís", "data_nascimento" : new Date(2004-10-03)})
{
    acknowledged: true,
        insertedId: ObjectId("64e58f468cf9ea4e38d8e911")
}

db.alunos.insertOne({"nome" : "Lucas Fernandes", "data_nascimento" : new Date(1999-03-19)})
{
    acknowledged: true,
        insertedId: ObjectId("64e58f548cf9ea4e38d8e912")
}

db.alunos.insertOne({"nome" : "Luana", "data_nascimento" : new Date(2004-11-20)})
{
    acknowledged: true,
        insertedId: ObjectId("64e58f6c8cf9ea4e38d8e913")
}

-- QUERY

db.alunos.find({"nome" : /[a-zA-z].e/})
[
  {
    _id: ObjectId("64e58f0d8cf9ea4e38d8e90f"),
    nome: 'Breno Franco',
    data_nascimento: ISODate("1970-01-01T00:00:01.978Z")
  },
  {
    _id: ObjectId("64e58f548cf9ea4e38d8e912"),
    nome: 'Lucas Fernandes',
    data_nascimento: ISODate("1970-01-01T00:00:01.977Z")
  }
]

db.alunos.find({"nome": "Luana"})
[
  {
    _id: ObjectId("64e58f6c8cf9ea4e38d8e913"),
    nome: 'Luana',
    data_nascimento: ISODate("1970-01-01T00:00:01.973Z")
  }
]

db.alunos.find({"nome" : /[a-zA-z].a/})
[
  {
    _id: ObjectId("64e58f0d8cf9ea4e38d8e90f"),
    nome: 'Breno Franco',
    data_nascimento: ISODate("1970-01-01T00:00:01.978Z")
  },
  {
    _id: ObjectId("64e58f2c8cf9ea4e38d8e910"),
    nome: 'Cayo Hollanda',
    data_nascimento: ISODate("1970-01-01T00:00:01.982Z")
  },
  {
    _id: ObjectId("64e58f548cf9ea4e38d8e912"),
    nome: 'Lucas Fernandes',
    data_nascimento: ISODate("1970-01-01T00:00:01.977Z")
  },
  {
    _id: ObjectId("64e58f6c8cf9ea4e38d8e913"),
    nome: 'Luana',
    data_nascimento: ISODate("1970-01-01T00:00:01.973Z")
  }
]

