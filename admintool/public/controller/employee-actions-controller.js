var employeeActionsControllerModule = angular.module('employeeActionsController', ['ngRoute']);
employeeActionsControllerModule.controller('EmployeeActionsController', function($scope, $routeParams, $http) {
        function refresh() {
            var employeeId = $routeParams.employeeId;
            $scope.employeeId = employeeId;
            $http.get("/employee-actions/rest/employee-actions-by-employee-id/" + employeeId).success(function (response) {
                $scope.employeeActions = response;
                    console.log("received success response for GET request " + JSON.stringify(response));
                }
            );
        }

        refresh();

        //$scope.addAction = function () {
        //    console.log($scope.action);
        //    //console.log($scope.test)
        //    $http.post("/action/rest", $scope.action).success(function (response) {
        //        console.log("received success response for POST request");
        //        $scope.isAddActionSuccessful = true;
        //    });
        //}

    });