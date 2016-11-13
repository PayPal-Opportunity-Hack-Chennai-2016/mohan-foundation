var xlControllerModule = angular.module('xlController', []);

xlControllerModule.directive('fileModel', ['$parse', function ($parse) {
    return {
        restrict: 'A',
        link: function(scope, element, attrs) {
            var model = $parse(attrs.fileModel);
            var modelSetter = model.assign;

            element.bind('change', function(){
                scope.$apply(function(){
                    modelSetter(scope, element[0].files[0]);
                });
            });
        }
    };
}]);


xlControllerModule.controller('XLController', function($scope, $http, $routeParams) {
    $scope.uploadFile = function(document){
        var file = $scope.myFile;
        var uploadUrl = "/export" + "/export" + "/" + document;
        uploadFileToUrl(file, uploadUrl);
    }

    var uploadFileToUrl = function(file, uploadUrl){
        var fd = new FormData();
        fd.append('file', file);

        $http.post(uploadUrl, fd, {
                transformRequest: angular.identity,
                headers: {'Content-Type': undefined}
            }).then(successCallback, errorCallback);
    }

    var successCallback = function (response){
        console.log("received success response for POST request, response :" + JSON.stringify(response));
        $scope.isAddDocumentSuccessful = true;
        $scope.isResponseReceivedFromServer = true;
        $scope.status = response.data;
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

});

