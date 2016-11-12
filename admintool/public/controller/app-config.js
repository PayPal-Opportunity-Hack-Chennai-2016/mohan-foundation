
var app = angular.module('trackerApp', ['ngRoute', 'actionController', 'actionViewController', 'employeeActionsController', 'employeeActionController', 'defaultersController', 'giveDataController', 'crudController', 'directives', 'xlController']);

function resolveDetails(dataArray) {
return {
    "collections": function() {
        return {
            data :  dataArray};
    }
};
}


app.config(['$routeProvider',
    function($routeProvider) {
        $routeProvider.
        when('/employees', {
            templateUrl: 'partials/employee-list.html',
            controller: 'CRUDController',
            resolve: resolveDetails(['employee', 'project'])
        }).
        // TODO why same controller for both list and new, refresh happens for employee-new also; same for action
        when('/employee/new', {
            templateUrl: 'partials/employee-new.html',
            controller: 'CRUDController',
            resolve: resolveDetails(['employee', 'project'])})
        .when('/employee/import', {
            templateUrl: 'partials/employee-import.html',
            controller: 'XLController'})
        .when('/employee/update/:id', {
            templateUrl: 'partials/employee-update.html',
            controller: 'CRUDController',
            resolve: resolveDetails(['employee', 'project'])})
        .when('/actions', {
            templateUrl: 'partials/action-list.html',
            controller: 'CRUDController',
            resolve: resolveDetails(['action', 'project'])
        }).
        when('/action/new', {
            templateUrl: 'partials/action-new.html',
            controller: 'CRUDController',
            resolve: resolveDetails(['action', 'project'])})
        .when('/action/update/:id', {
            templateUrl: 'partials/action-update.html',
            controller: 'CRUDController',
            resolve: resolveDetails(['action', 'project'])})
        .when('/employee-actions/employee/:employeeId', {
            templateUrl: 'partials/employee-actions-view.html',
            controller: 'EmployeeActionsController'
        }).
        when('/employee-actions/employee/:employeeId/action/:actionId', {
            templateUrl: 'partials/employee-actions-view.html',
            controller: 'EmployeeActionsController'
        }).
        when('/employee-actions/employee/:employeeId/action/:actionId', {
            templateUrl: 'partials/employee-action-view.html',
            controller: 'EmployeeActionController'
        }).
        when('/defaulters', {
            templateUrl: 'partials/defaulters.html',
            controller: 'DefaultersController'
        }).
        when('/report', {
            templateUrl: 'partials/report.html',
            controller: 'DefaultersController'
        }).
        when('/give-data/:actionId', {
            templateUrl: 'partials/give-data.html',
            controller: 'GiveDataController'
        }).
        when('/projects', {
            templateUrl: 'partials/project-list.html',
            controller: 'CRUDController',
                    resolve: resolveDetails(['project'])
        }).
        when('/project/new', {
            templateUrl: 'partials/project-new.html',
            controller: 'CRUDController',
            resolve: resolveDetails(['project'])})
       .when('/project/update/:id', {
            templateUrl: 'partials/project-update.html',
            controller: 'CRUDController',
           resolve: resolveDetails(['project'])})
        .when('/action/leave', {
            //TODO
            templateUrl: 'partials/',
            controller: 'ActionController'
        });
    }]);
