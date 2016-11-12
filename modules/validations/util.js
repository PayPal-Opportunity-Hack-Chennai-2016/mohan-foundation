/**
 * Created by t937426 on 5/5/2016.
 */


module.exports.validationsBasic = {
    checkProjectName : function (project) {
    var status = require("../domain/status.js");
        if (project && project.name && project.name.trim()) {
            return (new status(true, 'validation ok'));
        } else {
            return (new status(false, 'project name cant be empty'));
        }
    }
}

module.exports.validationsAgainstDb = {
    checkIfProjectExistsAlready : function (newProject, callback) {
        var status = require("../domain/status.js");
        var mongoUtil = require('../mongoutil');
        mongoUtil.connectToServer(function(err) {
                console.dir(err);
                mongoUtil.getAllDocuments('project', function(data){
                    var isDuplicate = false;
                    for	(var projectIndex = 0; projectIndex < data.length; projectIndex++) {
                        var project = data[projectIndex];
                        if(newProject.name == project.name && !(newProject._id == undefined || newProject._id == project._id)){
                            isDuplicate = true;
                            break;
                        }
                    }
                    if (isDuplicate) {
                        callback(new status(false, 'duplicate project'));
                    } else {
                        callback(new status(true, 'ok'));
                    }
                })
            }
        )
    }
}
