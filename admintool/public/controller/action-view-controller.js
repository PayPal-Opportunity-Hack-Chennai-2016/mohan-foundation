var actionControllerModule = angular.module('actionViewController', ['ngRoute']);

actionControllerModule.controller('ActionViewController', function ($scope, $routeParams, $http) {

    function refresh() {
        var actionId = $routeParams.viewActionId;
        console.log("$routeParams :" + actionId);
        $http.get("/action/rest/view-details-by-id/" + actionId).success(function (response) {
                $scope.action = response;
                console.log("received success response for GET request")
            }
        );
    }

    refresh();

    $scope.addAction = function () {
        console.log($scope.action);
        //console.log($scope.test)
        $http.post("/action/rest", $scope.action).success(function (response) {
            console.log("received success response for POST request");
            $scope.isAddActionSuccessful = true;
        });
    }

});