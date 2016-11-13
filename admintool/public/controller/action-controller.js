var actionControllerModule = angular.module('actionController', []);

actionControllerModule.controller('ActionController', function ($scope, $http) {
    function refresh() {
        $http.get("/action/rest/list").success(function (response) {
                $scope.actions = response;
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

    $scope.deleteAction = function (id) {
        console.log("id to delete" + id);
        //console.log($scope.test)
        $http.delete("/action/rest/" + id).success(function (response) {
            console.log("received success response for DELETE request")
            refresh();
        });
    }
});