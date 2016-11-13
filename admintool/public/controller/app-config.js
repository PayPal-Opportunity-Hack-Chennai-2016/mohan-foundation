
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
        when('/eyebanks', {
            templateUrl: 'partials/eyebanks.html',
            controller: 'CRUDController',
            resolve: resolveDetails(['eyebank'])
        }).
        when('/eyebank/new', {
            templateUrl: 'partials/eyebank-new.html',
            controller: 'CRUDController',
            resolve: resolveDetails(['eyebank'])})
        .when('/eyebank/import', {
            templateUrl: 'partials/eyebank-import.html',
            controller: 'XLController'})
        .when('/eyebank/update/:id', {
            templateUrl: 'partials/eyebank-update.html',
            controller: 'CRUDController',
            resolve: resolveDetails(['eyebank'])})
        .when('/skinbanks', {
                templateUrl: 'partials/skinbanks.html',
                controller: 'CRUDController',
                resolve: resolveDetails(['skinbank'])
            }).
        when('/skinbank/new', {
            templateUrl: 'partials/skinbank-new.html',
            controller: 'CRUDController',
            resolve: resolveDetails(['skinbank'])})
            .when('/skinbank/import', {
                templateUrl: 'partials/skinbank-import.html',
                controller: 'XLController'})
            .when('/skinbank/update/:id', {
                templateUrl: 'partials/skinbank-update.html',
                controller: 'CRUDController',
                resolve: resolveDetails(['skinbank'])})
            .when('/transplantcentres', {
                templateUrl: 'partials/transplantcentres.html',
                controller: 'CRUDController',
                resolve: resolveDetails(['transplantcentre'])
            }).
        when('/transplantcentre/new', {
            templateUrl: 'partials/transplantcentre-new.html',
            controller: 'CRUDController',
            resolve: resolveDetails(['transplantcentre'])})
            .when('/transplantcentre/import', {
                templateUrl: 'partials/transplantcentre-import.html',
                controller: 'XLController'})
            .when('/transplantcentre/update/:id', {
                templateUrl: 'partials/transplantcentre-update.html',
                controller: 'CRUDController',
                resolve: resolveDetails(['transplantcentre'])})
            .when('/organdonationhospitals', {
                templateUrl: 'partials/organdonationhospitals.html',
                controller: 'CRUDController',
                resolve: resolveDetails(['organdonationhospital'])
            }).
        when('/organdonationhospital/new', {
            templateUrl: 'partials/organdonationhospital-new.html',
            controller: 'CRUDController',
            resolve: resolveDetails(['organdonationhospital'])})
            .when('/organdonationhospital/import', {
                templateUrl: 'partials/organdonationhospital-import.html',
                controller: 'XLController'})
            .when('/organdonationhospital/update/:id', {
                templateUrl: 'partials/organdonationhospital-update.html',
                controller: 'CRUDController',
                resolve: resolveDetails(['organdonationhospital'])})
            .when('/ngoorgandonations', {
                templateUrl: 'partials/ngoorgandonations.html',
                controller: 'CRUDController',
                resolve: resolveDetails(['ngoorgandonation'])
            }).
        when('/ngoorgandonation/new', {
            templateUrl: 'partials/ngoorgandonation-new.html',
            controller: 'CRUDController',
            resolve: resolveDetails(['ngoorgandonation'])})
            .when('/ngoorgandonation/import', {
                templateUrl: 'partials/ngoorgandonation-import.html',
                controller: 'XLController'})
            .when('/ngoorgandonation/update/:id', {
                templateUrl: 'partials/ngoorgandonation-update.html',
                controller: 'CRUDController',
                resolve: resolveDetails(['ngoorgandonation'])})
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
