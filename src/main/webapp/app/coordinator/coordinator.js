'use strict';

var app = angular.module('myApp.coordinator', ['ngRoute']);

app.config(['$routeProvider', function ($routeProvider) {
        $routeProvider.when('/coordinator', {
            templateUrl: 'app/coordinator/coordinator.html',
            controller: 'CoordinatorCtrl',
            controllerAs: 'ctrl'
        });
        $routeProvider.when('/coordinator/newuser', {
            templateUrl: 'app/coordinator/createnewuser.html',
            controller: 'CoordinatorCtrl',
            controllerAs: 'ctrl'
        });
    }]);

app.controller('CoordinatorCtrl', ["$scope", "$http", function ($scope, $http) {
        $scope.newUser;
        $scope.createUser = function () {
            $scope.newUser.department = {nameOfDepartment : 'København'};
            var userTobesend = $scope.newUser;
            
            var jsonString = JSON.stringify(userTobesend);
            $http({
            method: 'POST',
            data: jsonString,
            url: 'api/coordinator'
          }).then(function successCallback(res) {
            $scope.data = res.data;
            console.log($scope.data);
          }, function errorCallback(res) {
            $scope.error = res.status + ": "+ res.data.statusText;
            console.log("ERROR");
            console.log($scope.error);

            });
        };

    }]);


