var express = require('express');
var router = express.Router();

var bodyParser = require('body-parser');
router.use(bodyParser.json());
router.use(express.static(__dirname + '/public'));

//mongoUtilModule
var mongoUtil = require('./modules/mongoutil');
mongoUtil.connectToServer(function(err) {
console.dir(err);
}
);

var Factory = require('./modules/validations').Factory;

process.on('uncaughtException', function (err) {
    console.log('Caught exception: ' + err);
});

router.get('/rest/list/:collectionName', function(req, res) {
        console.log("received get request :" + req.params.collectionName);
        mongoUtil.getAllDocuments(req.params.collectionName, function(data){
            console.log("response " + JSON.stringify(data));
          res.end(JSON.stringify(data));
       });
  });

router.get('/rest/view-details-by-id/:id', function(req, res) {
    var id = req.params.id;
    console.log("received get request for " + id);
    mongoUtil.getDocumentById('action', id, function(data){
    res.end(JSON.stringify(data[0]));
    });
  });

router.post('/rest/:collectionName', function(req, res) {
    var collectionName = req.params.collectionName;
    console.log("received post request : " + JSON.stringify(req.body) + " collectionName :" +  collectionName);
    // Factory.produce('new_' + collectionName + '_validator').validate(req.body, function(status) {
    //     if (status.success) {
    //         mongoUtil.insertOneDocument(collectionName, req.body);
    //         res.json(status);
    //     } else {
    //         res.status(400).json(status);
    //     }
    // });
    mongoUtil.insertOneDocument(collectionName, req.body);
    res.end();
});

router.put('/rest/:collectionName', function(req, res) {
    var collectionName = req.params.collectionName;
    console.log("received put request : " + JSON.stringify(req.body) + " collectionName :" +  collectionName);
    
            mongoUtil.updateDocument(collectionName, req.body);
            res.json();
       
        
    });


function validateProject(newProject, callback) {
    if(!newProject || !newProject.name || !newProject.name.trim())  {
        callback(new status(false, 'project name cant be empty'));
    }


}

router.delete("/rest/:collection/:id", function(req, res) {
    var id = req.params.id;
    console.log("received DELETE request for " + id);
    var collection = req.params.collection;
    console.log("received DELETE request for collection :" + collection);
    mongoUtil.deleteDocumentById(collection, id, function (err, results) {
        console.log(err);
    res.end();
    })
});

module.exports = router;

