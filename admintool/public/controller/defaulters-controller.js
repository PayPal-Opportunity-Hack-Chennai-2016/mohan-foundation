var defaultersControllerModule = angular.module('defaultersController', []);

defaultersControllerModule.controller('DefaultersController', function ($scope, $http) {
    function onLoad() {
        $http.get("/crud/rest/list/" + 'action').success(function (response) {
                $scope.actions = response;
                console.log("received success response for GET request")
            }
        );
    }

    onLoad();

    $scope.showDefaulters = function () {
        console.log("selected action _id:" + $scope.selectedActionId);
        $http.get("/defaulters/rest/action-id/" + $scope.selectedActionId).success(function (response) {
                $scope.defaulters = response;
                console.log("received success response for GET request : " + JSON.stringify(response));
            }
        );
    }

    $scope.showReport = function () {
        console.log("selected action _id:" + $scope.selectedActionId);
        $http.get("/defaulters/report/rest/action-id/" + $scope.selectedActionId).success(function (response) {
                $scope.report = response;
                console.log("received success response for GET request : " + JSON.stringify(response));
            }
        );
    }

});