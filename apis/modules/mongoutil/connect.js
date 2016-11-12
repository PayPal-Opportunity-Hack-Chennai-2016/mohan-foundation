var db = require('mongodb'); //var mangojs = require("mangojs");
var ObjectID = db.ObjectID;
var MongoClient = db.MongoClient;

var _db;

module.exports = {

  connectToServer : function( callback ) {
      MongoClient.connect( "mongodb://mohan:mohan@waffle.modulusmongo.net:27017/edU4gaxi", function( err, db ) {
      // MongoClient.connect( "mongodb://localhost:27017/mohan", function( err, db ) {
                          _db = db;
                           callback( err ); //return callback( err ); TODOD : What is the use of return here?
                        } );
                      },
 getCollection : function (collectionName) {
                    return _db.collection(collectionName);
                 },
  getDb : function() {
            return _db;
          },
  getAllDocuments : function (collectionName, callback) {
                        var stream = this.getCollection(collectionName).find({});
                        collectStreamData(stream, callback);
                    },
  getDocuments : function (collectionName, searchObject, callback) {
                        var stream = this.getCollection(collectionName).find(searchObject);
                        collectStreamData(stream, callback);
                    },
  getDocumentById : function (collectionName, id, callback) {
                    var stream = this.getCollection(collectionName).find({_id : ObjectID(id)}).stream();
                     collectStreamData(stream, callback);
                    },
  getDocumentByFieldName : function (collectionName, queryFieldName, queryFieldValue, callback) {
                  var query = {};
                  query[queryFieldName] = queryFieldValue;
                  var stream = this.getCollection(collectionName).find(query).stream();
                  collectStreamData(stream, callback);
    },
  insertOneDocument : function (collectionName, document) {
                        return this.getCollection(collectionName).insertOne(document);
                     },
  insertDocuments : function (collectionName, documents) {
      console.log("okkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk");
      return this.getCollection(collectionName).insert(documents);
   },
  updateDocument : function (collectionName, document) {
      document._id = ObjectID(document._id);
      return this.getCollection(collectionName).replaceOne({_id : document._id}, document);
  },
    deleteDocumentById : function (collectionName, id, callback) {
                        this.getCollection(collectionName).deleteOne({_id : ObjectID(id)}, function(err, results) {
                        callback (err, results)
                        });
                     }

};

function collectStreamData(stream, callback){
var documentsArray = [];
stream.on('data', function(data) {
       documentsArray.push(data);
 });
stream.on('end', function(data) {
         callback(documentsArray);
 });
}



//or u can use exports = method

