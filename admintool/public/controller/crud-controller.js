var crudControllerModule = angular.module('crudController', []);

crudControllerModule.factory('dataCache', function($cacheFactory) {
    return $cacheFactory('someCache', {
        capacity: 3 // optional - turns the cache into LRU cache
    });
})

crudControllerModule.controller('CRUDController', function($scope, $http,$location, $routeParams, dataCache, collections) {


    var updateDocumentId = $routeParams.id;


    function refresh(forceLoad, collectionName) {
        var cacheKey = collectionName + 'list';
        if(forceLoad || dataCache.get(cacheKey) == undefined) {
            $http.get("/crud/rest/list/" + collectionName).success(function (response) {
                    $scope[collectionName + 'Documents']=response;
                    dataCache.put(cacheKey, response);
                    console.log("received success response for GET request")
                }
            );
        } else {
            $scope.documents = dataCache.get(cacheKey);
        }
    }

    if (updateDocumentId == undefined) {
        var collectionsArray = collections.data;
        for (var i = 0; i < collectionsArray.length; i ++) {
            refresh(true, collectionsArray[i]);
        }
    } else {
        loadDocument();
    }

    function loadDocument() {
        var collectionsArray = collections.data;
        for (var collectionsIndex = 0; collectionsIndex < collectionsArray.length; collectionsIndex++) {
            var colelctionsName=  collectionsArray[collectionsIndex];
            var cacheKey = colelctionsName + 'list';
            var documents = dataCache.get(cacheKey);
            console.log("Collectionindex"+collectionsIndex);
            console.log("colelctionsName"+colelctionsName);
            if (collectionsIndex == 0) {
                for (var index = 0; index < documents.length; index++) {
                    var document = documents[index];
                    console.log("updateDocumentId"+updateDocumentId)
                    console.log("document._id"+document._id)
                    if (document._id == updateDocumentId ) {
                        $scope[colelctionsName + 'Document'] = document;
                        break;
                    }
                }
            } else {
                $scope[colelctionsName + 'Documents'] = documents;
            }

        }
    }


        $scope.addDocument = function(collectionName){
        console.log("collectionName" + collectionName);
        //console.log($scope.test)

        var successCallback = function (response){
            console.log(response)
            console.log("received success response for POST request, response :" + JSON.stringify(response));
            $scope.isAddDocumentSuccessful = true;

            $scope.isResponseReceivedFromServer = true;
            $scope.status = response.data;
            $scope.document={};
            $location.href='employees';
        }
        var errorCallback = function (response) {
            console.log("received error response for POST request, response :" + JSON.stringify(response));
            $scope.isResponseReceivedFromServer = true;
            if(response.status == 400) {
                $scope.status = response.data;
            } else {
                //
                $scope.status = {"message" : "Error : " + response.status + " " + response.statusText};
            }
            }

    $http.post("/crud/rest/" + collectionName, $scope.document).then(successCallback, errorCallback);

    }

    $scope.updateDocument = function(collectionName){
        console.log("updateDocument, collectionName" + collectionName);
        //console.log($scope.test)

        var successCallback = function (response){
            console.log("received success response for PUT request, response :" + JSON.stringify(response));
            $scope.isAddDocumentSuccessful = true;
            $scope.isResponseReceivedFromServer = true;
            $scope.status = response.data;
        }
        var errorCallback = function (response) {
            console.log("received error response for PUT request, response :" + JSON.stringify(response));
            $scope.isResponseReceivedFromServer = true;
            if(response.status == 400) {
                $scope.status = response.data;
            } else {
                //
                $scope.status = {"message" : "Error : " + response.status + " " + response.statusText};
            }
        }

        $http.put("/crud/rest/" + collectionName, $scope[collectionName + 'Document']).then(successCallback, errorCallback);

    }

    $scope.deleteDocument = function(collectionName, id){
        console.log(collectionName )
        $http.delete("/crud/rest/" + collectionName + "/" +id).success(function (response){
            console.log("received success response for DELETE request")
        refresh(true, collectionName);
        });
    }
});

