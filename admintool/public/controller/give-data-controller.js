var giveDataControllerModule = angular.module('giveDataController', ['ngRoute']);
giveDataControllerModule.controller('GiveDataController', function($scope, $routeParams, $http) {
    $scope.actionId = $routeParams.actionId;
    onLoad();
    function onLoad() {
        //console.log("actionId " + actionId);
        //    initializeActionResult(employeeId);
        //    $http.get("/employee-actions/rest/employee-action-by-their-ids/" + employeeId + '/' + actionId).success(function (response) {
        //        $scope.employeeAction = response;
        //            console.log("received success response for GET request " + JSON.stringify(response));
        //        }
        //    );
        }

      $scope.submitActionResult = function(){
            //console.log($scope.actionResult);
          console.log("actionResult :" + JSON.stringify($scope.actionResult));
           $http.post("/employee-actions/rest/action-result", $scope.actionResult).success(function (response){
                console.log("received success response for POST request");
            });
        }

        function initializeActionResult () {
            var actionResult = {};
            actionResult.employeeId = employeeId;
            actionResult.actionId = actionId;
            actionResult.fields = {};
            $scope.actionResult = actionResult;
        }
    });