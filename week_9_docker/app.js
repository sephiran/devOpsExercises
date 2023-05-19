const express = require('express');
const bodyParser = require('body-parser');
const MongoClient = require('mongodb').MongoClient;
const app = express();

app.use(bodyParser.urlencoded({ extended: true }));

const MONGODB_URL = 'mongodb://adrian:admin123@mongo:27017/mydb?authSource=admin';

let db;
MongoClient.connect(MONGODB_URL, { useUnifiedTopology: true }, (err, client) => {
  if (err) return console.error(err);
  console.log('Connected to MongoDB');
  db = client.db('mydb');
});

app.get('/', (req, res) => {
  res.sendFile(__dirname + '/index.html');
});

app.post('/submit-text', (req, res) => {
  db.collection('texts').insertOne(req.body, (err, result) => {
    if (err) return console.log(err);
    console.log('Text saved to MongoDB');
    res.redirect('/');
  });
});

app.get('/load-texts', (req, res) => {
  db.collection('texts').find().toArray((err, results) => {
    if (err) return console.log(err);
    res.send(results);
  });
});

app.listen(3000, () => {
  console.log('Server running on port 3000');
});
